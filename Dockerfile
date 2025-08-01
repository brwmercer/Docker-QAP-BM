FROM maven:3.9.6-amazoncorretto-21 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests
FROM amazoncorretto:21-alpine
LABEL authors="Your Name"
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar", "--debug"]