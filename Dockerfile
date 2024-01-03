FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-8-jdk -y

COPY src src

RUN apt-get install maven -y
RUN mvn clean install 

FROM openjdk:8-jdk-slim

EXPOSE 8080

COPY --from=build /target/sio-versao_1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
