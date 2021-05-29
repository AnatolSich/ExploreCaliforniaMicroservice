FROM openjdk:11
WORKDIR /
ADD target/exploreCalifornia-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-Dspring.profiles.active=docker", "-jar", "/exploreCalifornia-0.0.1-SNAPSHOT.jar"]
