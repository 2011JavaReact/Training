# Intro to TypeScript
TypeScript is an open-source programming language that is develped by Microsoft. TypeScript is a superset of JavaScript. It fixes a lot of the issues that are present and often does a better job of enforcing good practices that JS does not. For example, TypeScript is *actually* an object oriented programming language, and it *actually* has the ability to enforce static typing on your code.

Some features of TS:
- you can make classes and interfaces
    - abstract classes
- Strong/Static typing
- you can extends other classes to promote inheritance
- Generics
- Access Modifiers
    - public
    - private
    - protected
- Easier to read compared to JS
- function overloading
- constructors

The types in TS are a little different from the types in JS (in TS you get a couple of extra types). You can see the list of types available in TS [here](https://www.typescriptlang.org/docs/handbook/basic-types.html). 

TypeScript can be **transpiled** into JavaScript. Why does this matter? If you are doing web development or using a Node environment that runs JS chances are that you are operating with a system that can't *run* TS. But it can run JavaScript. Since TS is generally considered to be a better language for development, the usual workflow is for you to develop using TS and then convert it into JS by transpiling it with TSC (TypeScript Compiler). Note: be aware of the differences between compiling and transpiling.

# Setting up TypeScript for your Node environment
The following instructions should make it a little easier to work with TS in Node. It will allow you to code in TS and automatically put your JS files in the dist folder
1. Install typescript: `npm i -g typescript`
    - This allows you to convert .ts files to .js files using `tsc <name-of-file>`
2. Create tsconfig.json: `tsc --init`
3. Edit the tsconfig.json file
    - set "target" to "es6"
    - set "outDir" to "./dist"
    - set "rootDir" to "./src"
4. At this point calling `tsc` in command line should automatically transpile all of your TS in the /src folder into JS in the /dist folder
5. create a package.json file: `npm init -y`
6. install dev dependencies: `npm i -D typescript ts-node nodemon @types/node @types/express`
7. install express: `npm i express`
8. edit scripts in package.json to include the following:
    - `"start":"node dist/app.js"`
    - `"dev":"nodemon src/app.ts"`
    - `"build":"tsc -p ."`

You can watch this setup in this [video](https://www.youtube.com/watch?v=zRo2tvQpus8)
# Importing in TS
One neat thing about TS is that you can import and export modules using the ES6 specification which is arguably more robust than the CommonJS Specification that you use by default with JS in Node. Keep in mind that these are from ES6 specs (which TypeScript is good at utilizing) but is not unique to TS. Check out out these links to see more information on imports and exports:
- [Import](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import)
- [Export](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/export)

Examples of Importing:
```ts
    import defaultExport from "module-name";
    import * as name from "module-name";
    import { export1 } from "module-name";
    import { export1 as alias1 } from "module-name";
    import { export1 , export2 } from "module-name";
    import { foo , bar } from "module-name/path/to/specific/un-exported/file";
    import { export1 , export2 as alias2 , [...] } from "module-name";
    import defaultExport, { export1 [ , [...] ] } from "module-name";
    import defaultExport, * as name from "module-name";
    import "module-name";
    var promise = import("module-name");
```

Examples of Exporting:
```ts
    // export features declared earlier
    export { myFunction, myVariable }; 

    // export individual features (can export var, let,
    // const, function, class)
    export let myVariable = Math.sqrt(2);
    export function myFunction() { ... };
```

# Useful Links
- [TypescriptDocs](https://www.typescriptlang.org/docs/home.html)
- [TS in 5 min](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)
- [What is TS and why use it](https://dzone.com/articles/what-is-typescript-and-why-use-it)
- [Setting up Tyescript with Node and Express](https://www.youtube.com/watch?v=zRo2tvQpus8)