FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM amazoncorretto:17
WORKDIR /examination1
COPY --from=build /app/examination1/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
