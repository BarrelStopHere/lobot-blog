# Docker image for springboot application
# VERSION 0.0.1
# Author: ykr
 
### 基础镜像，使用alpine操作系统，openjkd使用8u201
### 也可以使用 java:8
#FROM openjdk:8-alpine
FROM anapsix/alpine-java:8_server-jre_unlimited

 
#作者
MAINTAINER ykr <1045607920@qq.com>
 
#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
 
#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp
 
#暴露端口
EXPOSE 8085
 
#定义参数
#ARG JAR_FILE
#应用构建成功后的jar文件被复制到镜像内
#ADD ${JAR_FILE} demo.jar
ADD target/admin-0.0.1-SNAPSHOT.jar app.jar
 
#touch命令的作用是修改这个文件的访问时间和修改时间为当前时间，而不会修改文件的内容。
#RUN bash -c 'touch /demo.jar'
 
#启动容器时的进程
ENTRYPOINT ["java","-Dfile.encoding=UTF8","-Duser.timezone=GMT+08","-jar","app.jar"]