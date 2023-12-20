FROM amazoncorretto:17

WORKDIR /deployments
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
