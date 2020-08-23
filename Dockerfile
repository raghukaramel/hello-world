# Dockerfile

#Build springboot app
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#Package docker image
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /home/app/target/hello-world-0.0.1-SNAPSHOT.jar /tmp/hello-world-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java" , "-jar", "/tmp/hello-world-0.0.1-SNAPSHOT.jar"]