# Use official OpenJDK image
FROM openjdk:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy jar file into container
COPY target/Authify.jar app.jar

# Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java","-jar","app.jar"]
