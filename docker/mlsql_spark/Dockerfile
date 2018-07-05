FROM mlsql_sparkenv:latest
MAINTAINER wuheyi

# 安装spark
# docker build -t mlsql_spark .
# settings.xml是mvn的配置文件

WORKDIR /mlsql_spark

COPY settings.xml /mlsql_spark

RUN cd /mlsql_python/software \
    && mkdir ~/.m2 \
    && cp /mlsql_spark/settings.xml ~/.m2 \
    && wget https://archive.apache.org/dist/spark/spark-2.2.0/spark-2.2.0-bin-hadoop2.7.tgz \
    && tar zxvf spark-2.2.0-bin-hadoop2.7.tgz \
    && rm spark-2.2.0-bin-hadoop2.7.tgz

