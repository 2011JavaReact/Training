# Hibernate

- hibernate is an ORM tool that is used to configure (map) the relationships between our java application (objects) and our database (relational)
- Hibernate is built on top of jdbc and abstracts away all of the "ceremony" or boiler plate code associated with JDBC
  - how much of it was the same each time?
  - establishing our connection, creating a PreparedStatement, manually mapping out each field to the correct column in the database, executing it, getting back the results, closing resources
- Establishing these relationships has many benefits to us as developers
  - we have the ability to use a code first approach when creating our database, meaning that we can generate our database entities automatically from our Java classes; this removes the obstacle of matching columns names and datatypes as that is abstracted away
  - manual mapping does not need to occur in DOA's, where each column is matched with each field
  - we can use hibernate methods which interact with our database and abstract away JDBC and allow us to perform db operations more simply

## Configuring Hibernate

In order to configure Hibernate one needs:

1. Hibernate Configuration (hibernate.cfg.xml file)
2. Hibernate Mapping (hbm.xml files or annotations)

## Using Hibernate

1. Session Objects
   - hibernate session ≠ http session
   - session is a lightweight object that represents the main interface between java and hibernate
   - a session facilitates CRUD operations on our mapped entities
   - life cycle of a session object is that of a logical transaction (can include several physical transactions)
2. Session Factory - a more heavyweight object which stores our database credentials and configuration - acts as a factory for hibernate sessions - is threadsafe and usually implemented as a singleton - lifecycle of a SessionFactory is the lifecycle of the java application
   Creating a Session Factory

- use a StandardServiceRegistry
- configure MetaData and MetaDataSources

```java
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
		      try {
		        // Create registry
		    	   registry = new StandardServiceRegistryBuilder().configure().build();
		        // Create MetadataSources
		        MetadataSources sources = new MetadataSources(registry);
		        // Create Metadata
		        Metadata metadata = sources.getMetadataBuilder().build();
		        // Create SessionFactory
		        sessionFactory = metadata.getSessionFactoryBuilder().build();
		      } catch (Exception e) {
		        e.printStackTrace();
		        if (registry != null) {
		          StandardServiceRegistryBuilder.destroy(registry);
		        }
		      }
		    }
		    return sessionFactory;
	}
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
Session s = HibernateUtil.getSession();
// use of hibernate session methods
// save, persist
// get, load
// update, merge
// getCriteriaBuilder
// createQuery
// beginTransaction
```

### Hibernate Configuration

- an xml file which provides session factory level configuration
  - url
  - pass
  - driver class
  - relationship to schema generation
  - show ddl
  - specify dialect

```xml
<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.url">url</property>
		<property name="hibernate.connection.username">admin</property>
		<property name="hibernate.connection.password">p4ssw0rd</property>
		<property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
		<property name="dialect">org.hibernate.dialect.Oracle12cDialect</property>
		<property name="hibernate.hbm2ddl.auto">validate</property>
		<property name="hibernate.show_sql">true</property>
		<mapping class="" />  <!-- looks in src/main/java for a class -->
		<mapping resource="" /> <!-- looks in src/main/resources hbm.xml -->
	</session-factory>
</hibernate-configuration>
```

### Mapping Configuration

- we need to provide configuration for how to map our java entities to our database entities
- this is either done with xml 'hbm' files or with annotations
- below is an example hbm file, mapping a java "Bear" class to a table in our db

```xml
<hibernate-mapping>
	<class name="com.revature.models.Bear">
		<id name="id" column="BEAR_ID">
			<generator class="increment"></generator>
		</id>
		<property name="name" type="org.hibernate.type.StringType" column="BEAR_NAME"></property>
		<property name="birthday" type="org.hibernate.type.DateType"></property>
		<many-to-one name="cave" column="CAVE_ID" class="com.revature.models.Cave" lazy="false"></many-to-one>
		<bag name="beehives" table="BEAR_BEEHIVE" lazy="false">
			<key>
				<column name="BEAR_ID" not-null="true"></column>
			</key>
			<many-to-many entity-name="com.revature.models.Beehive">
				<column name="BEEHIVE_ID" not-null="true"></column>
			</many-to-many>
		</bag>
	</class>
</hibernate-mapping>
```

## Hibernate Persistent States

### Transient

- object exists on the java side but there isn't a representation in the database that's being managed by a session

### Persistent

- there is an object managed by a session

### Detatched

- was once managed by a session but the session has been closed

## Get v Load

-> both used to retrieve a resource from a database (select statement for one object)

- load returns a proxy without hitting the database - a proxy is an anonymous subclass which has the same identifier but properties are not initialized yet
  - if the returned proxy is accessed during the scope of the same session, it will then hit the database; if the session is closed a LazyInitializationException will be thrown
  - if the object is not in the db will return an ObjectNotFoundException
- get will immediately hit the database and will return the object fully initialized
  - if no row is found, it will return null

### Query

- another way to get

## Update v Merge

- try to put a detached object in a persistent state

### update

- will throw a NonUnique object exception if there is already a persistent object with the same identifier
- throws an exception if not in the db
- void

### merge

- returns that object
- no exception if it doesn't exist
- no exception if

## Save v Persist

### persist

- attempts to make a transient object persistent
- void return type
- doesn't assure until flush time - when synchronizes (before some query executions, when a transaction committed)
- can execute insert statement outside of a transaction
- throws an exception if the method is called on a detached object

### Save

- attempts to make a transient or detached object persistent
- returns id, assures immediate access of primary key if it's generated
- can execute insert statement outside of a transaction
- both will generate a new identifier and insert the records in the db

# Session Methods

## Transactions

- autocommit by default is false
- Transaction tx = s.beginTransaction();
- commit and rollback methods

## Query v Criteria

### SQL

### HQL

- hibernate query language
- non-type-safe

### Criteria

- type-safe approach to querying
- we use CriteriaBuilder to create a CriteriaQuery
- once we configure our CriteriaQuery, we create a Query and pass our CriteriaQuery in as a parameter
- use criteria query to specify clauses
- use criteria builder to specify

## Named queries

- we can declare a query that we mahy want to reuse in our java class with a @NamedQueries annotation or with a `<query>` tag in an hbm file

```xml
<query name="getBearsByName">
	<![CDATA[from Bear where name = :nameVar]]>
</query>
```

```java
@NamedQueries({ @NamedQuery(name="getBearByCave", query="from Bear where name = :nameVar")})
```

### HQL vs Native SQL

# Inheritance Strategies

## Table Per Hierarchy

## Table Per Subclass

## Table Per Concrete Class

# Caching

## First Leveling Caching

- default caching level
- session scoped
- data for an operation is cached locally, if the same operation is made within the same session

## Second Level Caching
