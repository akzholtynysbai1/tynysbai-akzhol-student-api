# ===== Stage 1: build the application with Gradle =====
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --version --no-daemon
COPY src ./src
RUN ./gradlew bootJar --no-daemon

# ===== Stage 2: run the application with a small Java runtime =====
FROM eclipse-temurin:21-jre
LABEL maintainer="Akzhol Tynysbai, IT2-2306, ID 38313"
WORKDIR /app
COPY --from=build /app/build/libs/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
