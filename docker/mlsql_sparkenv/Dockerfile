FROM mlsql_python:latest
MAINTAINER wuheyi

# 安装spark需要的环境，jdk、scala、mvn
# docker build -t mlsql_sparkenv .

RUN mkdir software && cd software \
    && wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie"  \
    "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.tar.gz" \
    && wget https://downloads.lightbend.com/scala/2.11.12/scala-2.11.12.tgz \
    && wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz \
    && tar zxvf jdk-8u171-linux-x64.tar.gz \
    && tar zxvf scala-2.11.12.tgz \
    && tar zxvf apache-maven-3.5.4-bin.tar.gz \
    && rm jdk-8u171-linux-x64.tar.gz \
    && rm scala-2.11.12.tgz \
    && rm apache-maven-3.5.4-bin.tar.gz