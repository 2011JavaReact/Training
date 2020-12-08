# Redux
Redux is a predictable state container for JavaScript apps. It makes it "easier" to deal with state by providing a centralized location to deal with the state of your application. While you do not have to use Redux with React (Redux can also be used with Angular, Vue, and regular JavaScript), it is very common to have React applications that use Redux, especially for large enterprise applications. Note that Redux is not *always* a good fit for your react app. You should only use it if you need to. Redux can be fairly complex, so adding it to small applications, where it isn't needed could do more harm than good.

The "flow" for how Redux works involves **Actions**, **Reducers**, and a **Store**. When some event that effects state occurs in React, React will notify Redux that this event occurred. This results in an *action* being dispatched that will notify a *reducer* of this occurrence. The reducer will then update the state that is contained within the *store*. Upon this change occurring, the store will notify the necessary React components of the change.

 An *Action* is essentially something that describes a user's intent or perhaps something that occurred (kind of like an event). Actions are objects that consist of a type property(required) and any other property desired. Here is an example:
```JS
{type:'EXAMPLE_ACTION', data:'can be anything'}
```

A **Reducer** is a function that receives a state and an action as inputs and then returns the new state based off of the action that had occurred.  It is typical to see switch statements in Reducers:

```JS
function appReducer(state=defaultState, action){
    switch(action.type){
        case 'EXAMPLE_ACTION':
        //return new state
    }
}
```

A **Store** is the centralized location where state can be stored. The store cannot be changed directly. In order to change state contained in the store, you need to dispatch an action that will then trigger a reducer. One thing to keep in mind is that, in Redux, **state is immutable**. This means that whenever, you change state, you are not mutating the existing state directly. Rather, you are creating a new copy of state that has the desired properties.You can create a store using the following line of code:
```JS
const store = createStore(reducer);
```



- [Getting started with redux](https://redux.js.org/introduction/getting-started)

## React-Redux
React-Redux is a module that can be used to connect together React and Redux. The **React-Redux Provider** component connects your React App to the Redux store. Typically, you would wrap your application in this provider component so that it would have access to the store:
```JS
<Provider store={this.props.store}>
    <App/>
</Provider>
```

React-Redux also comes with a **connect** function wraps around our components so that they are connected to the Redux store:
```JS
export default connect(mapStateToProps, mapDispatchToProps)(PaperPage)
```
### mapStateToProps
**mapStateToProps** is used as the first argument to the connect functions in React-Redux. It is used to describe which state from redux is being exposed as props to the container component. A component often doesn't need all of the state available in the store, but you can definitely pass all of the state to the component if desired. Here is an example of using *mapStateToProps* in order to get all of the papers from the stores
```JS
function mapStateToProps(state){
    return {
        papers: state.papers
    }
}
```

One thing to note is that mapStateToProps triggers every time the component is updated. If you are doing performance expensive operations it could be a good idea to use a library that allows you to be more selective about which parts of mapStateToProps will actually re-trigger.

### mapDispatchToProps
This is the second argument in the connect function from React-Redux. It helps specify which actions should be exposed to the component. Here is an example of a mapDispatchToProps function:
```JS
function mapDispatchToProps(dispatch){
    return {
        actions:bindActionCreators(actions, dispatch)
    }
}
```

There are four main ways to handle mapDispatchToProps (make sure you are acquainted with all of them):
1. Ignore it - don't use it at all
2. Wrap manually
3. bindActionCreators
4. return an object instead of the function:

- [Docs for mapDispatchToProps](https://react-redux.js.org/using-react-redux/connect-mapdispatch)