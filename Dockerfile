FROM maven:3.9.5-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:21-jdk

COPY --from=builder /app/target/MotusAPI-1.0.0.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
