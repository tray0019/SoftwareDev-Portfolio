
# Use OPENJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

#Copy JAR from target folder
COPY target/Aug_Portfolio-0.0.1-SNAPSHOT.jar app.jar

#RUN the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

