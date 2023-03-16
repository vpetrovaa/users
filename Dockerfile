FROM maven:3.9-eclipse-temurin-17 as builder
WORKDIR /app
COPY .github ./
RUN mvn dependency:go-offline
RUN mvn clean install

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
EXPOSE 8087
COPY --from=builder /app/target/*.jar users.jar
ENTRYPOINT ["java", "-jar", "users.jar" ]