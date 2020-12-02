// We are importing from a package that is called 'http'
// http comes with node, so we do not need to npm install anything
// we will use this http object to create a server and have that server
// listen to requests
const http = require('http');

// we are creating a funciton that will be used as a callback in the app.on method.
// This listener will describe the behavior of the server upon receiving requests
// from the client with different paths. The exact response that is given depends on the
// user input
// note that there is definately a much better way of doing this. This example was only created
// to illustrate a concept
const sampleListener = (req,res)=>{
    //print out the path that was entered by the client
    console.log("path: " + req.url);

    // Let's say that our server has the ability to return data for an input of "/pokemon"
    if(req.url === "/pokemon"){
        // this represents data that is sent back to the client
        res.end("you asked for pokemon");
    }
    // Let's say that our server also has the ability to return data for an input of "/paper"
    else if(req.url === "/paper"){
        // this represents data that is sent back to the client
        res.end("you asked for paper");
    // If the user entered input that is not supported by the app, return a generic error message
    }else{        
        //note, this is not actually how you would do error handling
        res.end("You are wrong");
    }
}

//create the server
const app = http.createServer();

// app.on specifies an event listener. Essnetially, the server called "app" will
// exectue the logic specified in "sampleListener" every time that a "request" occurs
app.on('request',sampleListener);

// Tell the server to start a process that resides on port 3000 that is going to serve
// request from the user
app.listen("3000",()=>{
    // Indicate that the app is running
    console.log("server is running....");
});