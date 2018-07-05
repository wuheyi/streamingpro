FROM mlsql_streamingpro:latest
MAINTAINER wuheyi

# 配置kerberos认证，并启动streamingpro服务
# docker build --build-arg mode=pro -t mlsql_server .
# 其中xml文件为hadoop配置，krb5.conf为kerberos配置，bootstrap.sh为启动脚本

ARG mode=pro

WORKDIR /mlsql_server

COPY . /mlsql_server

RUN mkdir hadoopconf && cd hadoopconf \
  && cp /mlsql_server/$mode/*.xml . \
  && cp -rf /mlsql_server/$mode/krb5.conf /etc/krb5.conf \
  && cd ..

ENTRYPOINT chmod a+x bootstrap.sh && ./bootstrap.sh