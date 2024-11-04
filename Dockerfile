# Этап 1: Сборка приложения
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app

# Копируем файлы проекта и выполняем сборку
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Этап 2: Создание минимального образа с готовым приложением
FROM openjdk:17-jdk-slim
WORKDIR /app

# Копируем JAR-файл из первого этапа
COPY --from=build /app/target/*.jar app.jar

# Указываем команду запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
