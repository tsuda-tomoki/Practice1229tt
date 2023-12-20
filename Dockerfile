FROM amazoncorretto:17 AS build
WORKDIR /build
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM amazoncorretto:17
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
