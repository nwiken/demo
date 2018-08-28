# Dockerfile
FROM openjdk:8-jdk

VOLUME /data

COPY target/*.jar /app/smarthome.jar

CMD ["java", "-jar", "/app/smarthome.jar"]
