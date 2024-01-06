# Stage 1: Build stage
FROM ubuntu:latest AS build

# Set the working directory
WORKDIR /app

# Copy only the pom.xml to leverage Docker layer caching
COPY pom.xml .

# Copy the rest of the application files
COPY src src

# Install dependencies and build the project
RUN apt-get update 
RUN apt-get install -y openjdk-8-jdk maven 
RUN mvn clean package

# Stage 2: Runtime stage
FROM openjdk:8-jdk-slim

# Set the working directory
WORKDIR /app

# Expose the port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/sio-versao_1.jar app.jar

# Define the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]
