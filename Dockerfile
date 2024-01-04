FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-8-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean package

FROM openjdk:8-jdk-slim

EXPOSE 8080

COPY --from=build /target/sio-versao_1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
