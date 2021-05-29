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

### Documenting API.
Link to Swagger:
*[Swagger](http://localhost:8080/swagger-ui/index.html#/)

### Spring Security.
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

The authentication manager requires a password encoder bean in order to encode the plain text password
and then compares it to the previously encoded value in DB.

### JWT.
![Alt text](screens/SecurityVCRest.jpg?raw=true "Optional Title")
A common method is to invoke an API to authenticate, and then return to the client
a special encoded string called a token. Then, subsequent client requests
add the token to the HTTP header. OAuth is a frequently used implementation
of this type of methodology.
This application will use JSON Web Tokens, also known as JWT or jot.
![Alt text](screens/JWT-flow.jpg?raw=true "Optional Title")
JSON web tokens are encrypted data packets that have the following structure:
![Alt text](screens/JWT-header.jpg?raw=true "Optional Title")
The header has the type, which is a JSON web token, and it also has the hashing algorithm.
![Alt text](screens/JWT-payload.jpg?raw=true "Optional Title")
The payload has the subject of the token, the expiration of the token in terms of a date,
the iat which is the time the JWT was issued, the jti which is a unique identifier of the JWT
and then any application-specific key value pairs
It is the payload that includes the information about the principle, in this case the username and roles.
Plain text passwords should never be sent in the JWT payload.
![Alt text](screens/JWT-signature.jpg?raw=true "Optional Title")
We will also leverage Spring web filters to grab the tokens from their request header,
interpret them and inject them into the user's security context.

### Using docker and external MySql Database.

Final Product requires External MySql Database.
####Install Docker For Mac/Windows/Linux
Start MySql Container (downloads image if not found)

``
docker run  --detach   --name ec-mysql -p 6604:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=explorecali -e MYSQL_USER=cali_user -e MYSQL_PASSWORD=cali_pass -d mysql
``

view all images

``
docker images
``

view all containers (running or not)

``
docker ps -a
``

Interact with Database (link to ec-mysql container) with mysql client

``
docker exec -it ec-mysql sh -c "exec mysql -uroot -ppassword"
``

Stop ec-mysql container

``
docker stop ec-mysql
``

(ReStart) ec-mysql container

``
docker start ec-mysql
``

Remove ec-mysql container (must stop it first)

``
docker rm ec-mysql
``

Remove image (must stop and remove container first)

``
docker rmi mysql:latest
``

#####Mysql commands must be finished with ";" !!!

#### Startup with Profile settings
##### Default profile, H2 database
``
mvn spring-boot:run
``

or

``
java  -jar target/explorecali-2.0.0-SNAPSHOT.jar
``
##### mysql profile, MySql database (requires running container ec-mysql)
``
mvn spring-boot:run -Dspring-boot.run.profiles=mysql 
``

or

``
java  -Dspring.profiles.active=mysql -jar target/explorecali-2.0.0-SNAPSHOT.jar
``

####Pack app to jar in target

``
mvn package -DskipTests 
``

####Build docker image explorecalifornia from dockerfile

``
docker build -t explorecalifornia .
``
####Run docker container ec-app from image explorecalifornia

``
docker run --name ec-app -p8080:8080 -d explorecalifornia
``

####Check logs of docker container ec-app

``
docker logs ec-app
``

####Run docker container ec-app from image explorecalifornia with link to ec-mysql container

``
docker run  --name ec-app -p 8080:8080  --link ec-mysql:mysql -d explorecalifornia
``

