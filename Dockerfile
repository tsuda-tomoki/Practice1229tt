FROM amazoncorretto:17

FROM amazoncorretto:17 AS build
COPY ./ ./
RUN ./mvn clean package -Dmaven.test.skip=true

FROM amazoncorretto:17-alpine
COPY --from=build /target/examination1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
