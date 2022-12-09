FROM openjdk:oraclelinux8

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

LABEL "author"="liboshuai"
LABEL "version"="1.0"
LABEL "email"="liboshuai01@gmail.com"

ADD target/mall-tiny-01-1.0-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "-Djasypt.encryptor.password=BPQyqpWPacz5vCPVa", "/app.jar"]
