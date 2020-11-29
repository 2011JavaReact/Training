# Intro to JavaScript
JavaScript was created by Brendan Eich in 1995 during his time at Netscape. Since then, it has become the predomenant programming language for the web. Ironically due to its proliferative nature and a lot of the quirky design choices that were made about the language as it was being created, some conider the language to be one of the most hated in the world. At a surface level, facts about JavaScript can seem awkward and uncessarily confusing, where seemingly simple questions like "who owns JavaScript?", "is JavaScript really an Object-Orient Programming language?", or "is JavaScript compiled or interpreted?" have answers that are surprisingly nuanced. JavaScript has a lot of good and bad to it, but admittedly a lot of the bad qualities of JavaScript have been addressed relatively recently with the release of ES6 and subsequent releases. Nowadays, the language has a lot of versitility, but its reputation still suffers from the faults present in its first 20 years of existence. Today, JavaScript is defined by ECMAScript Language Specifications from the committe #tc39.

It is important to be able to descirbe what JavaScript is. At first, JavaScript was used primarily for developing client-side components of applications (web development). At a high-level, JavaScript can be described as a "**scripting** or programming language that allows you to implement complex featrues on web pages"([Mozilla](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps/What_is_JavaScript)). It is also usually considered an **interpreted** language when it is used for web developedment since you can give browsers JavaScript, and then browsers will know how to *interpret* these instuctions by default. 

When a browser runs JS, it uses some sort of engine to actually execute the script. Each browser has its own engine, but he one we are going to be conernec about is the V8 engine. This engine was developed by google and is present inside of the Google Chrome Browser.

# Intro to Node.js
In more recent years, there has been a growing trend of devolopers using JavaScript to write the logic for their servers as well. Hwoever, the runtime of server-side JS is often different Node.js is a server-side scripting language that is used to wrap around the V8 engine the JS uses. For our purposes it will contribute to the runtime that we use for our server-side applications. By default, Node.js comes with a lot of the features that are contained within ES6, but it also contains several features that are specific to Node.js

After installing Node, you can run .js files using the node command:
```bash
    node Name-Of-File.js
```

Node comes with Node Package Manager (npm). Npm is often used by developers to manage the dependencies that your code needs to run in Node. Package managers are useful, because it is not uncommon for a developer to require dozens if not hundreds of other packages written by other developers in order for his own program to function as intended. Manually maintaining all of these external packages is quite tedious, so have a tool do it for you will save a lot of time. Npm will also manage the verisons of the dependencies for you and can be used to do perform many actions such as, installing new packages, uninstalling old packages, and upgrading packages to newer versions.

One of the great features of Node is that by default it allows you to work with **modules**. A module is essentially a unit of JS code that is meant to be reused by means of *exporting* and then importing. By default, Node will allow you to do this using the CommonJS Specification. For example let's say you had a function that you wanted to reuse later on in a file called `add1.js`
```js
    function add1(arg){
        return arg +1;
    }
    module.exports= add1; //we are allowing for the function add1 to be imported by other files
```

Now let's say that we wanted to use this funciton in a different file, perhaps one called `other-file.js`. We can do so as seen below:
```js
    //the 'require' function imports the thing exported by the specified file
    let add1 = require('./add1'); 
    console.log(add1(4)); // prints out 5
```

The first line creates a variable called "add1" that is equal to the imported add1 function from the file called `add1.js`.

## Basic npm commands 

create a package.json for your project:
```bash
    npm init
```
install packages that are described in your package.json:
```bash
    npm install
```
install a package called <package_name>:
```bash
    npm install <package_name>
```
install a package globally called <package_name>:
```bash
    npm install -g <package_name>
```
install a package called <package_name> as a dev dependency:
```bash
    npm install -D <package_name>
```

More Command Line Interface (CLI) commands can be found [here](https://devhints.io/npm) 

# JavaScript Core
## Hello World
Here is the simplest example of JS I can think of. If you put it in a file called "helloworld.js" and run it with `node helloworld.js` it should print out "Hello World" in the command line.
<br>
helloworld.js
```js
    console.log("Hello World!");
```

## Declaring variables in JS
You do not have to declare variables in JS... but you really should. In the old days (pre ES6) you only had one option, which was to use var.
```js
    variable1 = "something" //This variable was not declared. But this is ok
```
```js
   var variable1 = "something" //This variable was declared. Which is also ok
```
If you do not declare your variable in JS, it will automatically be declared using the `var` keyword. The two examples above are equivalent. Variables declared with the `var`keyword are subjected to "hoisting" which you can read about [here](https://developer.mozilla.org/en-US/docs/Glossary/Hoisting).

With the release of ES6 `let` and `const` can also be used to declare variables and allow for block scoping. Know the difference between [global, local, and block scope](https://scotch.io/tutorials/understanding-scope-in-javascript).
```js
   var variable1 = "something" //var can cause a variable to be locally or globablly scoped
```
```js
   let variable1 = "something" //let allows for block scoping
```
```js
   const variable1 = "something" //const allows for block scoping
```
Variables declared with var can be redeclared. Variables declared with let and const cannot be redeclared. Variabled declared with const cannot have their value changed.

As a side note, it is generally bad practice to use `var` nowadays so don't do it.

## Types in JS
You do not have to indicate a type when you declare a variable in Javascript. In addiiton, JS is **Dynamically typed** or **Loosely Typed** which means that variables are not associated with any particular type and can be reasigned to values with different types. For example, the following is ok:
```js
    let myVar = 9001; // myVar is a number
    myVar = "now it is a string?"; // myVar is reassigned to a string
    myVar = false; //Now it is a boolean
```

Under the ECMAScript standard, there are nine types. The first 6 are pimitives, the last three are more nuanced:
- 6 primitive types:
    - undefined
    - Boolean
    - Number
    - String
    - BigInt
    - Symbol
- null
- object
- function

Note that there is some nuance to this list, and people argue back and forth over whether or not certain types are technically its own type. For example functions are technically objects and null is technically also an object (this statement is a gross oversimplification). Just roughly know what the types are.  
- more info [here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Data_structures)
## == vs ===
Double equals (`==`) will roughly do its best to compare two values. Tripple equals(`===`) will check to see if the two values that it is comparing is actually the same.
```js
    console.log(2=='2'); //true
    console.log(2==='2'); //false
```
`==` will perform what is called **type coercion** in order to change the type of one of the values to match the other in order to make the comparison. As a rule of thumb, you should generally use `===` over `==` whenever possible.

## Objects
Objects are used to store non-primitive data in JS. Objects exist as a set of name/value pairs. All objects are descended form `Object` and always inherit methods and properties from thier prototype. Objects can be created in various ways including using an object literal, creating an object from a function, or creating a class (ES6 and later) and creating an object form the class. See example folder my example on js objects. Here is an example of an object that might represent a car:
```js
// creating an object using a literal:
let house = {
    owner: "William",
    address: "123 4th Street",
    year: 2005
}
    // objects contain name/value pairs. To get the value, you use the . notation and refer to the property that you are trying to access
console.log(house.owner); //prints out "William"
``` 

You can add new properties to an object reletively easily. All you have to do is add it using . notation:
```js
    house.material = brick // this will add a property to house called "brick"
```
## Functions
A function is a subroutine that is often used to call the set of logic that is contained within it. In JS functions are objects. Functions often take argumetns and may or may not return a value. The following is a simple funciton declaration.
```js
function myFunc(myArg){ //declare a function using the 'function' keyword
    //insert whichever logic you want right here
}
```
In JS, you are allowed to return the function itself rather than the execution of the function.
```js
function newFunc(){
    return 'NewFun called!';
}
// what do you think is the difference between the following two lines of code?
console.log(newFunc);
console.log(newFunc());
// the () indicates that the expression is returning the execution of a function
```
### Callback Functions
In JavaScript, you are allowed to pass in functions as arguments for other functions. The function that is passed in as an argumetn to another function is the **callback function**.
```js
// this function is going to be used as an argument for the next function
function argumentFunc(){
    return 'I am going to be called later!';
}

//this function is going to accept another function as an argument
function caller(callbackFunc){
    //log to the conosle whatever it is that the argument function returns
    console.log(callbackFunc());
}
caller(argumentFunc);
```
### Arrow Functions
In JS, you can create functions using a shorthand notation called an **arrow function**. Here is an example of a simple arrow function that will add two numbers together. There are optional syntaxes and more advanced conepts which are described [here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions).
```js
    let sum = (a, b)=> {return a + b}; 
    console.log(sum(4,5)); //returns 9
```
### Anonymous Callback Functions
If you are calling a function that takes a callback function, you are allow provide an anonymous function as an argument to the calling function if you do not want to define the function somewhere else in your code. Here is an example of defining two named functions in order to write a(n overcomplicated) program that will multiply two numbers together.
```js
        //this function will return the product of the two arguments
    function multiplyTwo(a,b){
        return a*b;
    }

    //this function will call the previous arguments and pass in 5 and 6 as the arguments
    function caller(callbackFunc){
        return callbackFunc(5,6);
    }
    //log the result of calling the caller function with multiplyTwo as an argument
    console.log(caller(multiplyTwo));
```
Alternatively, you can opt to not declare multiplyTwo at all and just use an anonmymous function that will be declared as it is being called.
```js
//this function will call the previous arguments and pass in 5 and 6 as the arguments
function caller(callbackFunc){
    return callbackFunc(5,6);
}
//log the result of calling the caller function with multiplyTwo as an argument
console.log(caller(function (a,b){ //rather than naming a function called "multiplyTwo" just feed in the anonymous function
        return a*b;
    }));
```

You can do the same thing, but use an arrow function instead (which is the preferred method)
```js
//this function will call the previous arguments and pass in 5 and 6 as the arguments
function caller(callbackFunc){
    return callbackFunc(5,6);
}
//log the result of calling the caller function with multiplyTwo as an argument
console.log(caller((a,b)=>{ //rather than naming a function called "multiplyTwo" just feed in the arrow function
        return a*b;
    }));
```

If you don't come from a JavaScript background, this could look seriously messed up in your head, but you'll get the hang of it eventually.
## Arrays
Arrays are datastructures that can be used to to hold sets of data. They are technically objects and do not have a fixed size (they can dynamically change in length). Here is how you can create an array:
```js
    let cats = ['lion', 'tiger', 'ocelot'];
```
Here are some important array methods and properties that can be called on the array:
- length: gives the length of the array
- ForEach(<callback>): loops through array and executes the callback function
- push(<item>): adds <item> to the end of the array
- indexOf(<item>): returns index of <item>
- reduce(<callback>): reduces the array to just one value. You can use the callback to describe how you want this to be done
- map(<callback>): creates a new array that is the result of the callback function applied to each element
- filter(<callback>): creates a new array only consisting of elements from the old array that meets some condition provided in the callback
- some(<callback>): returns a boolean that represents whether or not at least one element in an array meets the condition described in the callback funciton.
You can read more about arrays [here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array).
## Control flow
The following are different ways you can control the progression of you logic in JS. [Here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Control_flow_and_error_handling) are the common syntaxes for control flow in JS. Here is an example of a simple if-else statement:
```js
    let boolExpression =true;
    if (boolExpression){
        console.log("Input was true");
    }else{
        console.log("Input was false");
    }
```
Here is an example of a switch statement:
```js
let expression = "hello"
switch(expression){
    case "howdy":
        console.log("Case1 triggered");
        break;
    case "hello":
        console.log("Case2 triggered");
        break;
    case "hola":
        console.log("Case3 triggered");
        break;
    default:
        console.log("Default triggered");
}
```

It is also important to understand how to create different loops (traditional for loop, foreach loop, while, etc) Know the difference between a for...in statemetn and a for...of statement.

## Error/Exception Handling.
Errors in Javascript represent some anomaly occuring that indicate something is occurring in a way that is contrary to the desired use of the program. An error is either the `Error` object in JS itself, or some object that inherits from `Error`.The developer has the ability to make errors so they can ensure the program is used according to its intended purpose. The developer also has the ability to handle errors that they are anticipating, so that they can continue to keep the program running despite an error occuring. You can cause an error to happen using the `throw` keyword:
```js
    throw new Error('Error Message');
```

You can create a new Error by extending from the error class:
```js
    class CustomError extends Error{
        // some code here
    }
    throw new CustomError();
```

You can deal with Errors occuring by using try/catch blocks. You use them by placing code that might cause an error in a `try` block while placing the code that would trigger instead of the error crashing your code in the `catch` block.
```js
    try{
        throw new Error('Some Error Message');
    }catch(e){
        //code that exectues instead of code crashing
        console.log("An error occurred:" + e.); //log the error
    }
```
For information:
- [Error Handling in Node](https://nodejs.dev/error-handling-in-nodejs)

# Event Loop and Asynchronus JavaScript
JS manages memory using a stack, a heap and a queue (known as the event loop). In JS, there is only one stack, yet somehow it is able to function asynchrounously and acheive concurrency. Here are some good resources that help explain how exactly JS acheives this:
- [EventLoop on MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop)
- [What the Heck is the Even Loop Anyway?](https://www.youtube.com/watch?v=8aGhZQkoFbQ)

# Asynchronous JS
## Events
An **event** is simply an occurance that happens at some point while your program is executing. An example of this is someone connecting to your server. The object that announces the occurence of an event is called and **event emitter**. In JS, it is possible to create function that will respond to a certain event that the is being emitted. These functions are called **event handlers** or **event listeners**. The practical use case is that, when a user connects to your server, an event emitter will notify your program that someone has made a request. As the developer, you can create an event handler that will trigger every time a user makes a request to specify how exactly you want your program should act in the event of a clent request. For more info:

- [Node.js Events](https://www.w3schools.com/nodejs/nodejs_events.asp)
- [EventEmittter Class](https://www.tutorialspoint.com/nodejs/nodejs_event_emitter.htm)
## setInterval/setTimeout
`setInterval` and `setTimeout` can be used to cause some function to occur asynchrounously. `setTimeout` will cause a function to execute after X number of miliseconds:
```js
    function sayHello(){
        console.log('Hello!');
    }
    
    setTimeout(sayHello, 5000); // call the sayHello function in 5 seconds
```

`setInterval` behaves similarily, except it will call the function over and over every X miliseconds:
```js
    function sayHello(){
        console.log('Hello!');
    }
    
    setInterval(sayHello, 5000); // call the sayHello function EVERY 5 seconds
```
## Promises
Promises are an object in JS that represent the eventual output of some operation. So for example, you can think of a scenario where you ask me for a chicken. Let's say that rather than give you a chicken I hand you and egg, which basically just represents the *promise* of a chicken. It is important to note that there are two main outcomes you can expect with promises. Either they are fulfilled (the egg hatches into a chicken) or some failure occurs (the egg breaks... and doesn't hatch into a chicken). Regardless, the value of a promise is that it allows the program to continue on asynchronously without having to wait for the actual expected end-goal to be achieved immediately. Essentially, a Promise allows for you to ask me for a chicken me say "Sure, I'll get you one in 20 days", without you having to physically wait here for me to make you a chicken. You could theoretically continue to execute other operations while waiting for the chicken to be produced.

You have the ability to create a promise using the `new` keyword with the `Promise` class, but you typically don't make your own Promises. Usually, you should understand Promises so that you can use promises that are returned by other functions that you are using.
Sources:
- [MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise)
## async/await
# Testing with Jest
It is important to test our code so that it is easier to maintain. We will be using Jest to test the code that we write in node. It can be used to **test** functions to make sure that they work as well and also **mock** the functionality of functions that we are not testing at the moment.

You can install jest using:
```bash
npm install -D jest
```
The `-D` option is indicating that jest should be installed as a dev dependency rather than a regular dependency (since you really only need it in development environments and not in your production environment)

When performing unit testing, you would usually create a function in perhaps a file called `sum.js`:
```js
    function sum(a, b) {
        return a + b;
    }
    module.exports = sum;
```

to check to see if the code is funcitoning as intended, you can write a test, perhaps in a file claled `sum.test.js`:
```js
    const sum = require('./sum');

    test('adds 1 + 2 to equal 3', () => {
        expect(sum(1, 2)).toBe(3);
    });
```

You can read more about jest [here](https://jestjs.io/docs/en/getting-started). You can see how mocking functions work [here](https://jestjs.io/docs/en/mock-functions).

# Misc
Here are additional concepts within JS that you should acquaint yourself with.
- Prototypal Inheritance
- Closures
- Guard Operator
- var args
- truthy falsey

# Sources/Useful Links
- [JavaScript Documentation from Mozilla](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
- [Node.js Docs](https://nodejs.org/en/docs/)
- [JavaScript Wikipedia Page](https://en.wikipedia.org/wiki/JavaScript)
- [ECMAScript Language Specification for 2019](https://www.ecma-international.org/publications/files/ECMA-ST/ECMA-262.pdf)
- [Is JavaScript compiled or interpreted?](https://www.thoughtco.com/interpreted-or-compiled-2037502)
- [npm](https://docs.npmjs.com/about-npm/)