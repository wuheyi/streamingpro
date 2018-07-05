FROM mlsql_spark:latest
MAINTAINER wuheyi

# 编译streamingpro项目
# docker build -t mlsql_streamingpro .
# bootstrap.sh 执行打包命令

WORKDIR /work

COPY . /work

RUN chmod a+x bootstrap.sh && ./bootstrap.sh
