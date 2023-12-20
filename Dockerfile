# ビルド用のステージ
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /build
COPY ./ ./
RUN mvn clean package -Dmaven.test.skip=true

# 実行用のステージ
FROM amazoncorretto:17
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
