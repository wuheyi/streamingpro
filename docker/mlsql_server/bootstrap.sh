#!/usr/bin/env bash

export SCALA_HOME=/mlsql_python/software/scala-2.11.11
export PATH=$PATH:$SCALA_HOME/bin
export SPARK_HOME=/mlsql_python/software/spark-2.2.0-bin-hadoop2.7
export PYTHONPATH=$SPARK_HOME/python/:$SPARK_HOME/python/lib/py4j-0.10.4-src.zip:$PYTHONPATH
export PYSPARK_PYTHON=/usr/bin/python
export PYSPARK_DRIVER_PYTHON=/usr/bin/python
export PATH=$SPARK_HOME/bin:$PATH
JAVA_HOME="/mlsql_python/software/jdk1.8.0_171"
export PATH="$PATH:$JAVA_HOME/bin"
MAVEN_HOME=/mlsql_python/software/apache-maven-3.5.4
export PATH=$PATH:$MAVEN_HOME/bin
export HADOOP_CONF_DIR=/mlsql_server/hadoopconf


kinit -r7d -kt /keytab/wuheyi.keytab wuheyi@CDH.HOST.DXY
spark-submit --jars  hdfs:///public/app/mlsql/keras/nlp-lang-1.7.8.jar,hdfs:///public/app/mlsql/keras/ansj_seg-5.1.6.jar,hdfs:///public/app/lib/jar/skone-udf-1.0-SNAPSHOT.jar \
   --class streaming.core.StreamingApp --driver-memory 1g --master local[2]  \
   --conf "spark.scheduler.mode=FAIR" --conf "spark.driver.extraJavaOptions=-XX:MaxDirectMemorySize=10G" \
   --conf spark.ui.port=4046 --name sql-interactive /work/streamingpro-mlsql/target/streamingpro-mlsql-1.1.1.jar \
   --keytab /keytab/wuheyi.keytab \
   --principal wuheyi@CDH.HOST.DXY \
   -streaming.name mlsql \
   -streaming.job.file.path hdfs:///public/app/mlsql/mlsql.json \
   -streaming.platform spark \
   -streaming.rest true -streaming.driver.port 9015 -streaming.spark.service true \
   -streaming.thrift false -streaming.enableHiveSupport true \
   -streaming.udf.clzznames"streaming.crawler.udf.Functions,streaming.dsl.mmlib.algs.processing.UDFFunctions"
