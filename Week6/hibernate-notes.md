# Hibernate

## What is Hibernate?
- ORM (object relational mapper) solution introduced Gavin King way back in 2001
- Can be used to query and persist objects from/to the database
- Maps Java classses to database tables, including Java data types to SQL data types
- Simplifies the process of data persistence tasks

### Advantages
- Open source and lightweight
- Uses caching, so that not every query has to "hit" the database
- Database independent querying: utilizes HQL (Hibernate Query Language), you can think of it as the OOP version of SQL
- We can also specify hibernate to automatically create tables for us, which saves a lot of time
- Simplifies joins since objects and their dependencies are mapped by hibernate
    - Relationships:
        - One to One
        - One to Many (Many to One)
        - Many to Many

### JPA
- JPA (Java Persistence API): The standard API in Java for accessing, persisting, and managing data between Java objects and relational databases.
    - JPQL to perform database operations
    - Uses the **EntityManager** interface to create, read, update, and delete instances of mapped "entity" classes
- Hibernate is an implementation of JPA, so it follows the common standard laid out by the JPA specification
- Hibernate's Session interface is an extension JPA's EntityManager interface

## Hibernate Hierarchy
- Configuration class
    - Provides the ability to specify configurations
    - We might provide a hibernate.cfg.xml file, which will contain for instance our general hibernate configurations as well as possibly our username and password to the database
    - Builds our SessionFactory
- SessionFactory interface
    - Creates Session objects
    - Thread-safe
        - An application will typically have only one SessionFactory that can be shared by all threads
- Session interface
    - The main way for Java applications to interact with Hibernate
    - Provides the ability to create, read, and delete objects
- Transaction interface
    - Allows units of work to be defined
    - A session can have multiple transactions
        - But only 1 uncommitted transaction at a time

### JPA Annotations
- @Entity
    - Defines a class that is to be mapped by Hibernate
    - Entity also refers to classes/objects that are mapped to the relational database
- @Table
    - Allows the table name to be specified for the class we want to map to the database
- @Id
    - Defines which field acts as the primary key of our entity
- @Column 
    - Allows for defining the column name in the database
    - Can also specify
        - The max column length
        - Whether the column must be unique
        - Whether it can be nullable
- Mapping annotations
    - @OneToOne
    - @OneToMany (@ManyToOne)
        - ex. One planet has many satellites
        - @JoinColumn: the name you want for the foreign key column
    - @ManyToMany
        - @JoinTable
            - @JoinColumn

## Cache
Hibernate can utilize caching to provide performance benefits

- L1 Cache
    - Built in and provided automatically
    - Runs at the session level
    - Mandatory
- L2 Cache
    - Not built in, but can be added
    - Scoped to SessionFactory, so can span across different sessions
    - Can have optimizations across multiple sessions
        - This can become a complex topic

## Object States
Objects are synchronized with the DB through hibernate sessions, and can have different states depending on when/if they are synchronized

- Transient
    - An object that is newly created
    - Not synchronized with the DB
    - This is just a normal Java object that Hibernate has not started keeping track of yet
- Persistent
    - Object whose state is currently being managed and tracked by Hibernate
    - Synchronized through the session with the DB
- Detached
    - An object that was previously persistent, but the session that it was associated with was closed
    - We could also specify to detach an object from a currently open session
    - No longer synchronized with the DB

There is a feature whereby Hibernate automatically saves changes made (such as via setters) to a **persistent** object called "Automatic dirty checking" after the transaction is committed or the session is flushed. 

Flushing
- This is the process of synchronizing with the DB with objects that are currently persistent
- You can explicitly invoke this by using session.flush()
- Or flushing also occurs when a transaction is committed.

## Retrieving data from DB
- HQL
- JPQL
- Native SQL
- Criteria API
    - Type safe
    - Criteria use explicit methods and return types to fetch data
