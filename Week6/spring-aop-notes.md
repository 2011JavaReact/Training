# AOP - Aspect Oriented Programming
- Breaking down program logic into "cross-cutting-concerns"
    - Cross-cutting-concern: Something that is used throughout your application / "cuts" across different layers, classes, methods, etc. 
    - Examples: Logging, Security, Caching, Validation, etc.
- Break down these concerns into units that we refer to as "aspects"
    - You can think of an aspect as basically a class that contains different pieces of "advice" (methods)
- We can annotate our class with @Aspect in order to address a particular concern
    - @Aspect is from the AspectJ library, which is actually a full AOP framework, but Spring AOP also can use AspectJ annotations
- So basically, we write code within our Aspect class, that will be "injected" into other locations of our codebase

# Join Point
- The location in which the **advice** code will be injected
- A JoinPoint is represented by method execution
- So when some method you would like to inject your code into is invoked, the advice will basically be executed

# PointCut
- Predicate that specifies which JoinPoints (methods) will be affected
    - It's analogous to regular expressions
- A collection of JPs that match a particular criteria specified by the PointCut is where the advice will be injected

# Advice
- The actual code that will be injected at a JoinPoint
- Many different types of Advice:
    - @Before
        - Advice that will execute before the JoinPoint
    - @After
        - Advice that will execute after the JoinPoint (regardless of whether the JoinPoint throws an exeception or executes and returns normally)
        - @AfterReturning
            - Execute after the JoinPoint returns successfully with no exceptions thrown
        - @AfterThrowing
            - Execute after the JoinPoint throws an exception
    - @Around
        - Allows for advice to be injected before and after the JP execution
        - Most powerful type of advice, and can do things like stopping method execution, stopping exception propagation, etc.
- Advice is associated with PointCuts and run at matching JoinPoints
- JoinPoint interface is able to be passed into any aspect method
    - Gives us access to the **target** object
    - Allows us to get the JointPoint method signature, arguments, etc.
- ProceedingJoinPoint which is a sub-interface of JoinPoint that can be passed into a method that handles @Around advice, and only @Around advice.
    - This gives us access to the .proceed() method that will actually execute the JoinPoint

# Types of PointCut Expressions
- execution
    - Most common, and basically specifies which methods to have as our JoinPoints
    - "execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)"
        - modifiers-pattern: public, private, protected
        - return-type: void, String, int, boolean, Object, etc...
        - declaring-type-pattern: class name that the method belongs to
    - Parameter pattern wildcards
        - () : matches a method with no arguments
        - (*) : matches a method with one argument of any type
        - (..) : matches a method with 0 or more arguments of any type
    - Reuse pointcut expressions
        - @PointCut to specify a pointcut "template"
    - Combine pointcuts
        - can use logic operators like &&, ||, !
