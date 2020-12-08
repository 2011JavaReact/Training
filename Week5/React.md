# Intro to React

React is a JavaScript **library** that was created in 2011 by Facebook for the purpose of creating front end user interfaces for web applications. React by itself is very small and lightweight. It is meant to be used in conjunction with other modules such as **React Router** and **Redux**. This gives developers a lot of freedom and options in how they want to go about assembling the tools that they need to develop UIs. While it is primarily used to make front-ends for web applications, React theoretically has other use cases. You can also use React to help build static websites, mobile applications (using React Native), desktop applications, and Virtual Reality (React VR).

- [React Docs](https://reactjs.org/)
- [Why React is taking over front-end](https://jscomplete.com/learn/why-react)

## Creating a new React Application
There are many ways of setting up your environment to start writing a UI with React. The simplest and most popular way is to use `create-react-app` and the `npx` command:
> npx create-react-app "name-of-react-application"

This will generate a new React application that comes preconfigured with dependencies such as: babel, webpack, jest, etc.

Note that this is a shortcut and you could always manually set up your dev environment if you wanted to. 

- [create-react-app](https://create-react-app.dev/docs/getting-started)
## "Not a Framework"

Technically, React is a *library* and not a *framework*. How is not being a framework a good thing? A framework is usually an entity that takes your code and executes a lot of abstracted away processes. Typically, frameworks offer limited flexibility because they do things in their own way and they expect the developer to closely conform to the intended way of doing things. As a consequence, they run the risk of being very large and full of features. In some cases, you are forced to use the entire thing, and sometimes, they can be hard to customize. This can be cumbersome, if you only wanted to use a small piece of the framework without having to use the whole thing. React is "not a framework" because it it small and is really only designed to do one thing: enable users to declaratively describe their user interfaces (and model the state of these interfaces). This is one of the main ways that React differs from other popular frameworks that are used for web development (Angular, Vue, Ember, etc.). You will find that React was ground-breaking because its approach to web development was so fundamentally different from other solutions.

## Tradeoffs

React is a Library, not a framework. This means that it doesn't get to benefit from the opinionated nature of frameworks that make it easier to make less choices and set up the application. React trades conciseness for a more explicit approach to web development. Rather than allowing a framework to hook everything up for you, you wire everything explicitly with React. Another tradeoff is that rather than simply using templates like in more traditional front-end frameworks, React is basically "using html in your JS". This does require you to understand JS to a greater depth than with other frameworks. React's components structure doesn't follow the traditional MVC file separation of other frameworks. All of the data regarding a component is in the same file. React does follow the principle of "Separation of Concerns", but rather than doing so by separating HTML,CSS,JS, it separates them based on component functionality

## Downsides to React

In the interest of fairness, here are some of the major downsides to React: JSX differs from HTML, the inclusion of a build step, potential version conflicts, old features of React in searches, decision fatigue. JSX is mostly similar to HTML, but there are a few differences such as having to use "className" instead of "class" (remember that `class` is a keyword in JS). Nowadays, most methods of creating front-end clients that require frameworks will require, so this is probably going to be a thing unless you are using vanilla HTML, CSS, JS. Since there is a runtime to React, multiple React components need to all be on the same version. Since React is a popular tool, there are a lot of posts online, regarding React, which might also mean that you will have a hard time distinguishing which methods are relevant now and which ones are outdated. Finally, the fact that React is so flexible results in a lot of decision fatigue. There are a lot of choices you have to make, which usually falls into the these categories: Dev Environment, Classes or Functional components, Types, State, Styling.

# React Concepts

There are certain themes that you will notice as you use React more and more. One really big one is that when you use React, a lot of the time, you are just making use of the features of JS. Competing frameworks often have their own opinionated way of abstracting out JS functionality, but React does the opposite. Getting better at React will make you better at JS. Furthermore, in React, you will use *HTML in your JavaScript code* rather than the other way around. This will be accomplished thorough using *JSX*, which is a syntax extension of JS.

## JSX
JSX stands for JavaScript XML and it allows you to write what looks like HTML inside of your JS code in React. Think of it as a convenient way of conceptualizing what your view will look like without having to leave your JS file. For example, the following element can be created using JSX in a regular JS file:
```JS
const myElement =(
    <div>
      <h1>Hello</h1>
        <p>Have a great day!</p>
    </div>
); 
```

Here is equivalent JS for a situation where you wanted to create an element without JSX:
```JS
const myElement = React.createElement("div", null, React.createElement("h1", null, "Hello"),React.createElement("p", null, "Have a great day!"));
```

It is kind of like the concept of how you can either create an element using HTML, or by using the createElement() DOm function to achieve the same goal. In addition, JSX works by utilizing Babel to compile the JSX into regular ES5 or ES6 JavaScript before everything is rendered. Note that if you want to write any JS in JSX, you must enclose it in curly braces {}.

- [JSX according to React Docs](https://reactjs.org/docs/introducing-jsx.html)
- [Babel compiling JSX to JS](https://babeljs.io/repl#?browsers=defaults%2C%20not%20ie%2011%2C%20not%20ie_mob%2011&build=&builtIns=false&spec=false&loose=false&code_lz=GYVwdgxgLglg9mABAQQA6oBQEoDeAoASACcBTKEIpAHgAsBGAPgAkSAbVuKgenobwF8gA&debug=false&forceAllTransforms=false&shippedProposals=false&circleciRepo=&evaluate=false&fileSize=false&timeTravel=false&sourceType=module&lineWrap=true&presets=env%2Creact%2Cenv&prettier=false&targets=&version=7.9.6&externalPlugins=)

## Virtual DOM
React uses a Virtual DOM. Technically, with React, you don't actually write HTML. Instead, you generate HTML views using JS. For every DOM object, react has a corresponding "virtual DOM object" that represents the actual DOM object. Why is using a Virtual DOM useful? Updating the DOM is costly in terms of performance. React greatly improves performance by minimizing changes to the DOM. The Virtual DOM much more lightweight than the actual DOM, so the virtual DOM is updated whenever we make a change, but React will decide when it is most efficient to actually make the real DOM reflect the changes seen in the Virtual DOM. Since rendering the page is costly (performance wise), minimizing unnecessary renders is one way that React improves performance.
- [React Docs - Vitual DOM](https://reactjs.org/docs/faq-internals.html)
- [React:The Virtual DOM](https://www.codecademy.com/articles/react-virtual-dom)

# React Components
In React, a component is a reusable piece of your UI. The idea is that grouping your front end into reusable pieces, will help with the maintainability of your code. React has the ability to render components in order to display the view. There are two main ways that Components are created nowadays. The traditional way of creating components was through declaring a Class-based component as seen below:

```JS
import React from 'react'

class Hello extends React.Component{
    render(){
        return <p>Hello World!</p>
    }
}
```

The alternative way of declaring an equivalent component is through using functions instead:
```JS
import React from 'react'

function Hello(){
    return <p>Hello World!</p>
}
```

note that you can also use arrow functions to create functional components:
```JS
import React from 'react'

const Hello = () => {
    return <p>Hello World!</p>
}
```

Back in the day, class based components used to be considered as more powerful, but in recent releases of React, functional components should be able to achieve most of the same use cases as class based components (functional components used to not have the ability to deal with state, but that changed with React Hooks). In general, functional components can be used for almost every scenario where a class based component is needed, and are the preferred way of creating components in React because it requires less typing and is more concise (there is also some speculation that class based components might be deprecated at some point in the future).

## Props
In React, components can be nested in other components (often referred to as parent and child components). **Props** are passed from parent to child. For example here is a Kangaroo component that had a child component called Joey:
```JS
function Kangaroo(props){
    return (
        <div>
            <h3>I am a kangaroo and I have a child calle 'Joey'</h3>
            <Joey secret="property to be passed..."/> {/*The parent Kangaroo Component is passing a prop called 'secret' to its child, Joey*/}
        </div> 
    );  
} 
```

```JS
function Joey(props){
    return(
        <div>
            {props.secret /*this evaluates to 'property to be passed...'*/}
        </div>
    )
    
}
``` 

Joey is receiving a prop called 'secret' with a value 'property to be passed...' from its parent, Kangaroo. In React, props are immutable, and cannot be changed by the child.

- [React Components and Props](https://reactjs.org/docs/components-and-props.html)
## State
If there was a situation where you wanted to change data that is being used, you would use **state**. You can set state in class components by either using a constructor or by declaring a field called 'state' inside of the class. In general, you do not mutate state directly. To change state in a class component, you would use `this.setState()`.

If you wanted to use state inside of a functional component, you would need to use  hooks. To mutate state, you would need to use the mutator function that you declare while using the hook.

- [State and Lifecycle](https://reactjs.org/docs/state-and-lifecycle.)
- [Using the state hook](https://reactjs.org/docs/hooks-state.html)
## Component Lifecycle
There are several lifecycle steps that a component will go through. Knowing the names of methods or hooks that correspond to certain phases in the component lifecycle is useful for functions that you want to call during certain steps of the lifecycle.

![ReactComponentLifeCycle](.\ReactComponentLifecyle.png)

- [React Component Lifecycle Docs](https://reactjs.org/docs/react-component.html)

## Container vs Presentation Components
React isn't very opinionated, so theoretically you could structure your components however you would like. However, over the years, there have been certain best practices that have emerged regarding how you should create your components. One popular pattern is to use one component for purely the presentation of the data, and another that manages the state and logic of that presentational component. Typically the 'presentational' component is made a child of the 'container' component. Note that this relationship has many names. Here are some common ones:  Container and Presentation, Smart and Dumb, Controller and View, Data and Display.

There are also more advanced techniques for combining components called *Higher order Components*.

- [Types of Component Patterns](https://www.youtube.com/watch?v=YaZg8wg39QQ)
- [Higher Order Components Docs](https://reactjs.org/docs/higher-order-components.html)

# React Router
In general, an increase to the number of hits to a server greatly slows down your application. How do we mitigate this? By reducing the number of times your browser makes requests to the server. A **Single Page Application** is a frontend UI that contained in only one file. Rather than actually requesting different HTML files from the server, react will swap out the existing HTML on the page, for another set of HTML to give the illusion of page navigation without actually having to make another request of the server. **React Router* can be used to create this single page application.

# More resources
- [Practice React on CodePen](https://codepen.io/pen?&editable=true&editors=0010)
- [React Course with Class Components](https://www.youtube.com/watch?v=DLX62G4lc44)