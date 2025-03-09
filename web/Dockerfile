FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER ykr <1045607920@qq.com>
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
VOLUME /tmp
EXPOSE 8602
ADD target/picture-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dfile.encoding=UTF8","-Duser.timezone=GMT+08","-jar","/app.jar"]