 #!/usr/bin/env bash

 export SCALA_HOME=/mlsql_python/software/scala-2.11.12
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

 mvn -DskipTests clean package  -pl streamingpro-mlsql -am  -Ponline -Pscala-2.11  -Phive-thrift-server -Pspark-2.2.0 \
        -Pdsl-legacy  -Pshade -Pcarbondata -Pcrawler -Popencv-support
