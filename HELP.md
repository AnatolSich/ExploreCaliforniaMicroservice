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
