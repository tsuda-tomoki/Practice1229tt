FROM maven:3.8.4-openjdk-17 AS build
WORKDIR  /examination1
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM amazoncorretto:17
WORKDIR /examination1
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
