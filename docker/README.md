## dockerfile构建流程
* 进入mlsql_python目录，docker build -t mlsql_python .
* 进入mlsql_sparkenv目录，docker build -t mlsql_sparkenv .
* 进入mlsql_spark目录，docker build -t mlsql_spark .
* 进入项目的根目录，docker build -t mlsql_streamingpro .
* 进入mlsql_server目录，docker build --build-arg mode=pro -t mlsql_server .  注：pro为线上模式，dev为线下模式
* 启动streamingpro项目，docker run -it -v {包含keytab的路径}:/keytab -p 9015:9015 mlsql_server
* 通过localhost:9015/run/sql和localhost:9015/run/script可以执行任务，具体参考https://github.com/allwefantasy/streamingpro