FROM ubuntu:latest

RUN apt-get update
RUN apt-get install openjdk-8-jdk -y

# Defina um diretório de trabalho para os arquivos do projeto
WORKDIR /app

# Copie os arquivos do seu projeto para o diretório de trabalho no contêiner
COPY . /app

RUN apt-get install maven -y
RUN mvn clean install 

FROM openjdk:8-jdk-slim

EXPOSE 8080

COPY --from=build /app/target/sio-versao_1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
