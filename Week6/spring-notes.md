# Spring Framework Overview
## Goals
- Lightweight Development with POJOs (Plain Java Objects)
- Dependency Injection, to promote loose coupling
    - Loose Coupling: Basically when you're developing, you might use a bunch of different dependencies within a certain class, and you might want to have different implementations, so we can use DI to achieve this by simply "injecting" objects in as we specify
- Declarative Programming with AOP (Aspect Oriented Programming)
- Minimization of boiler code

## Modules
- Core Container
The core of Spring for creating beans, and also for managing bean depencies
    - Beans: spring-beans module
    - Core: spring-core module
    - Context: (spring-context & spring-context-support)
    - SpEL: Spring Expression Language

Core and beans modules provide the fundamental parts of the Spring framework, such as IoC (inversion of control) and DI (dependency injection). **BeanFactory** is an implementation of the factory design pattern, which removes the need to create programmatic singletons and enables the decoupling of configuration and specification of dependencies from the program logic itself.

Context builds upon the Core and Beans modules and allows for access to objects in a framework-style manner. It supports Java EE features like EJB, JMX, and basic remoting. **ApplicationContext** extends upon BeanFactory.

## Spring Projects
- These are basically modules built on top of the core modules of Spring Framework
- Spring Boot
- Spring Cloud
- Spring Data
- Plenty more

# Inversion of Control (IoC)
The approach of outsourcing the construction and management of objects

- In Spring, we will basically outsource instantiation and management of objects to the ApplicationContext, which functions as the object factory
- This is our IoC container that contains all of the instantiated objects
- IoC allows for loose coupling
- Instead of hardcoding a particular implementation, we can use configuration to specify to the IoC container which objects we want to be instantiated
    - XML configuration (ApplicationContext.xml) (the old way of doing things)
    - Annotations (modern)
    - Java class based (modern)

# Dependency Injection
- A pattern to implement IoC
    - This is not exclusive to Spring, it's just describing a pattern where behavior is injected into our classes (for example, Angular also has ways to do DI)
    - Dependency: some object that we want to use in our class
    - Injection: Passing the dependency to a dependent object

In order to achieve IoC, we need to
1. Configure our Spring Beans
2. Create a Spring Container
3. Retrieve Beans from the Spring Container (or IoC container)

# Bean Scopes
Scopes determine how many instances of a bean we create, which depends on the context in which they are used.

Universal Scopes
- Singleton (default): Only 1 instance of the bean at a time
- Prototype: New bean is created each time it is requested from the container

Web-Aware Scopes
- Request: One new bean per HTTP Request
- Session: One per HTTP Session
- New Spring 5 Scopes
    - Application: One per ServletContext (aka per web container)
    - WebSocket: One per WebSocket
- Deprecated
    - Global session

# Bean Wiring
- Just like how there are various ways to register and configure beans for our IoC container, we can also have various ways to wire dependencies together
- Bean wiring is the process of providing dependencies through DI

## Constructor Injection
- Uses the constructor to pass in dependencies
- We provide a constructor with the necessary dependencies as constructor arguments
- This ensures that the object is not instantiated until the dependencies are first initialized and ready for injection

## Setter Injection
- Uses setter methods to provide dependencies
- More readable than alternative
- Does not ensure DI because an instance can be created without configuring a particular field, that field will just be null
    - We can, however, use a @Required annotation to ensure that the dependency is provided
        - We might want to do this to prevent NullPointerExceptions from occuring somewhere down the line

# Bean Lifecycle 
## Initialization
0. Request Bean from ApplicationContext
    - Instantiation
    - Populate properties
1. BeanNameAware's setBeanName method
2. BeanClassLoaderAware's setBeanClassLoader method
3. beanFactoryAware's setBeanFactory method
4. EnvironmentAware's setEnvironment method
5. BeanPostProcessor's postProcessBeforeInitialization method
6. InitializingBean's afterPropertiesSet method
7. Custom init method
    - Init method in our bean declaration (applicationContext.xml)
    - @PostConstruct annotation
8. BeanPostProcessor's postProcessAfterInitialization method

## On Shutdown of ApplicationContext
1. DestructionAwareBeanPostProcessor's postProcessBeforeDestruction method
2. DisposableBean's destroy method
3. Custom destroy method
    - Destroy method in bean declaration (applicationContext.xml)
    - @PreDestroy annotation

### Custom methods
- Custom init: we can specify a method that we would like to run when the bean is first initialized (maybe for some setup purposes)
- Custom destroy: we can specify a method that we would like to run before the bean is destroyed (for cleanup purposes usually)

## Conceptual Level
- Setup
    - Object instantiated
    - Dependencies are assigned to instance variables
    - Custom initialization method invoked if provided
    - Spring Bean Ready
- Tear Down
    - Spring destroy method
    - Custom destroy method

# Configuration
We have many different choices of configuration. We can use the different configuration types independently and exclusively, or we can use them together with each other. In particular, there is 

1. XML configuration
2. Java class configuration
3. Annotation configuration. 
    - To use this configuration type, we will need to enable it by specifying, for example `<context:component-scan base-package="com.revature">` in our .xml, or if we're using AnnotationConfigApplicationContext, the `@ComponentScan` on our Java class that is serving as a configuration class (`@Configuration`)

