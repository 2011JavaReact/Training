# Spring MVC
## What is Spring MVC?
- Spring MVC (or Spring Model-View-Controller), is a framework built around the concept of model, view, controller that enables web application functionality. 
- It is based on the Servlet API
- A special Servlet called the DispatcherServlet is used to dispatch requests to controllers
- Controllers act as the entry-point into the core business logic of the application by, for example, connecting to the service layer
- There is also another special component that composes the view called the ViewResolver, which can be used to handle view templates like JSPs, or static files like HTML

## General Workflow of Spring MVC
- The request is sent to the Servlet engine (Tomcat)
- Tomcat forwards the request and response objects to the DispatcherServlet
	- org.springframework.web.servlet.DispatcherServlet
	- This should be configured in our deployment descriptor, web.xml
- From here, the Servlet consults our handler mapping
	- There are many different ways of doing this
	- In our case, we are using org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
	- We can configure in our applicationContext.xml
		- <mvc:annotation-driven />
- The handler mapping returns to the DispatcherServlet which Controller to send the request to
- The Controller will then send the response back to the DispatcherServlet, and if it is a View, it will consult the view resolver
- Otherwise, it will send the response back as data
	- JSON
	- Images
	- Files
	- XML
	- etc

## Annotations
- @Controller: specifies a class as a controller, which is a special bean used to handle web application requests
- @RequestBody: allows Spring to map data from the body of an HTTP Request to a Java object
- @ResponseStatus: used to mark a method or exception with an HTTP response status code
- @RequestParam: used to bind request parameters to variables in the method signature params
- @PathVariable: used to bind properties specified directly in the URL mapped for a certain method
- @RequestHeader: In addition to request parameters and body content, header data can be viewed and mapped to a method in a similar syntax to the @RequestParam annotation
- @ResponseBody: Used to automatically marshal java object into JSON
- @RestController: same as @Controller, but implicitly adds @ResponseBody 