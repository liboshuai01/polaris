# Base images 基础镜像
FROM java:8u111

#MAINTAINER 维护者信息
MAINTAINER liboshuai<liboshuai01@gmail.com>

#VOLUME：挂载目录
VOLUME /temp

#ADD  将microservicecloud-eureka-7001-1.0-SNAPSHOT.jar文件将拷贝到容器中，默认拷贝到根路径下
#注意：microservicecloud-eureka-7001-1.0-SNAPSHOT.jar的名称前的microservicecloud-eureka-7001对应<artifactId>标签中的内容，1.0-SNAPSHOT对应<version>标签中的内容
ADD ./target/oms-service-1.0-SNAPSHOT.jar app.jar

RUN bash -c "touch /app.jar"

#EXPOSE 容器暴露端口
EXPOSE 8081

#ENTRYPOINT 应用启动命令 参数设定
#由于tomcat的session id的生成主要通过java.security.SecureRandom生成随机数来实现，导致启动过程很慢
#通过-Djava.security.egd=file:/dev/./urandom参数可以加快随机数产生过程
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
