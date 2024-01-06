FROM ubuntu:latest AS build

WORKDIR /app

# Copy only the pom.xml to leverage Docker layer caching
COPY pom.xml .

# Copy the rest of the application files
COPY src src


RUN apt-get update
RUN apt-get install openjdk-8-jdk -y


# Copie os arquivos do seu projeto para o diretório de trabalho no contêiner
COPY . /app

RUN apt-get install maven -y
RUN mvn clean install 

FROM openjdk:8-jdk-slim

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/sio-versao_1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar" ]
