FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD mall-admin-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/app.jar"]