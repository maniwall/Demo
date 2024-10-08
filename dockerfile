# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot app will run
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
