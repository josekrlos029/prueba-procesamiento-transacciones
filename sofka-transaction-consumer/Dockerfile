FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY /target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]