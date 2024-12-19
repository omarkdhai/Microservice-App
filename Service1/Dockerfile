# Use a base image with OpenJDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container (make sure to build the JAR before)
COPY target/Service1.jar /app/Service1.jar

# Expose the port your app will run on
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "Service1.jar"]
