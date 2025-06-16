FROM ubuntu:latest
LABEL authors="Dell"

ENTRYPOINT ["top", "-b"]
# Use official Maven image to build the app
FROM maven:3.9.0-eclipse-temurin-24 AS build

# Set work directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the Spring Boot application, skipping tests for speed
RUN mvn clean package -DskipTests

# Use slim OpenJDK 24 image to run the application
FROM eclipse-temurin:24-jdk-jammy

# Set work directory in container
WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/QLBH-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
