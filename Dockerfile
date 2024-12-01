FROM openjdk:21-jdk-slim
VOLUME /tmp
EXPOSE 8000
ADD ./target/client-service-0.0.4-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]