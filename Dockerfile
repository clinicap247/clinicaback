FROM maven:3.8.5-openjdk-17 AS build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application.
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY --from=build target/*.jar app.jar
COPY .env .env  

# Define environment variables
# ENV DB_URL=jdbc:postgresql://pgsql:5432/content_television
# ENV DB_NAME=db_mongo

# Base de datos
ENV DB_HOST=
ENV DB_PORT=
ENV DB_NAME=
ENV DB_USERNAME=
ENV DB_PASSWORD=

# ENV DB_PASSWORD=password
# Buket
# ENV S3_ENDPOINT=
# ENV S3_ACCESS_KEY=
# ENV S3_SECRET_KEY=
# ENV S3_BUKET_NAME=

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "/app.jar"]