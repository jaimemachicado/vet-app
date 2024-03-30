# Build application with maven
FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests


# JKD 17 image
FROM openjdk:17-oracle as runtime
# Copy the jar file from the builder stage to the runtime stage
COPY --from=builder /app/target/*.jar app.jar
# Expose app at port 8080
EXPOSE 8080
# Command to run the application
ENTRYPOINT ["java","-jar","/app.jar"]
