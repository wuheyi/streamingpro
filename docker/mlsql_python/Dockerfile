FROM debian:latest
MAINTAINER wuheyi

# 安装python2相关的库
# docker build -t mlsql_python .
# requirements.txt包含了需要安装的包及其版本

WORKDIR /mlsql_python

COPY requirements.txt /mlsql_python

RUN apt-get update && apt-get install -y python vim wget python-setuptools git \
        && DEBIAN_FRONTEND=noninteractive apt-get install -y krb5-user \
        && easy_install pip py4j && pip install -r /mlsql_python/requirements.txt \
        -i http://pypi.douban.com/simple --trusted-host pypi.douban.com \