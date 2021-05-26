# Guides

### General
Initial domain model:

![Alt text](screens/domain-model.jpg?raw=true "Optional Title")

How to limit access to endpoints:

![Alt text](screens/Repo-endpoint-override.jpg?raw=true "Optional Title")
![Alt text](screens/Repo-methods-restrictions.jpg?raw=true "Optional Title")

Link to HAL Browser:
*[HAL Browser](http://localhost:8080/browser/index.html#/)

MVC vc REST:

![Alt text](screens/SpringDataRestVCSpringMVC.jpg?raw=true "Optional Title")

Validation annotations:

![Alt text](screens/Validation-annotations.jpg?raw=true "Optional Title")

### Logging
Logger is responsible for capturing events, appender records the events and 
layouts are gresponsible for the appearance of the data in the log entry:

![Alt text](screens/Logging-structure.jpg?raw=true "Optional Title")

#### Logging frameworks.
Abstraction layer SLF4J decouples an application from any framework and allows to bind
to spesific framework at runtime:

![Alt text](screens/Logging-frameworks.jpg?raw=true "Optional Title")

Each class instantiates a class scoped logger,
then calls methods on it to record the events
according to its imports or severity.

ExploreCalifornia uses the Logback framework,
where there are four kinds of events:
error, warning, info, debug and trace.

Error is the highest and most severe event

#### Documenting API.
Link to Swagger:
*[Swagger](http://localhost:8080/swagger-ui/index.html#/)

#### Spring Security.
Spring Security makes a couple assumptions.
First of all it assumes that all of our APIs must be forbidden, and protected,
and second it assumes that the authentication scheme will be form-based authentication
and each user will have a Servlet session.
It blocked all the applications, but the sign-in API should always be open.
WebSecurityConfiguration extends WebSecurityConfigurerAdapter - center of security configuration.
We override web security configuration adapter's configure method in order to change the default behavior
of the HTTP security object, so when we invoke of the HTTP security object, so when we invoke
it will tell Spring security how to handle different APIs.

Because we created a stateless restful API, we need to tell Spring security that cross-site
request forgery detection should be disabled, and that no sessions should be created for it.
So session creation policy is stateless.