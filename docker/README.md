## dockerfile构建流程

如果从头构建，需要先生成下面的三个基础镜像：
* 进入mlsql_python目录，docker build -t mlsql_python .  然后上传到私仓[docker tag mlsql_python:latest registry.uc.host.dxy/dxy/mlsql_python:latest docker push registry.uc.host.dxy/dxy/mlsql_python]
* 进入mlsql_sparkenv目录，docker build -t mlsql_sparkenv . 然后上传到私仓[docker tag mlsql_sparkenv:latest registry.uc.host.dxy/dxy/mlsql_sparkenv:latest docker push registry.uc.host.dxy/dxy/mlsql_sparkenv]
* 进入mlsql_spark目录，docker build -t mlsql_spark . 然后上传到私仓[docker tag mlsql_spark:latest registry.uc.host.dxy/dxy/mlsql_spark:latest docker push registry.uc.host.dxy/dxy/mlsql_spark]

正式发布后，只需要执行下面的步骤：
* 进入项目的根目录，docker build -t mlsql_streamingpro .
* 进入mlsql_server目录，docker build --build-arg mode=pro -t mlsql_server .  注：pro为线上模式，dev为线下模式
* 启动streamingpro项目，docker run -it -v {包含keytab的路径}:/keytab -p 9015:9015 mlsql_server
* 通过localhost:9015/run/sql和localhost:9015/run/script可以执行任务，具体参考https://github.com/allwefantasy/streamingpro