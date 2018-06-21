# Pull base image.
FROM registry.uc.host.dxy/library/maven

# Define working directory.
WORKDIR /work

# Prepare download dependencies
ADD . /work/

RUN mvn -DskipTests clean package  -pl streamingpro-mlsql -am  -Ponline -Pscala-2.11  -Phive-thrift-server -Pspark-2.2.0 -Pdsl-legacy  -Pshade -Pcarbondata -Pcrawler -Popencv-support

# Define default command.
ENTRYPOINT /opt/spark-2.2.0/bin/spark-submit --jars hdfs:///public/app/mlsql/keras/nlp-lang-1.7.8.jar,hdfs:///public/app/mlsql/keras/ansj_seg-5.1.6
.jar,hdfs:///public/app/lib/jar/skone-udf-1.0-SNAPSHOT.jar --class streaming.core.StreamingApp --driver-memory 12g --master local[8] --conf "spark.scheduler.mode=FA
IR" --conf "spark.driver.extraClassPath=/opt/cloudera/parcels/GPLEXTRAS/lib/hadoop/lib/*" --conf "spark.driver.extraJavaOptions=-XX:MaxDirectMemorySi
ze=10G" --conf spark.ui.port=4046 --name sql-interactive /work/streamingpro/streamingpro-mlsql/target/streamingpro-mlsql-1.1.0.jar    -streaming.name keras-ope
ncv    -streaming.job.file.path hdfs:///public/app/mlsql/mlsql.json -streaming.platform spark   -streaming.rest true   -streaming.driver.port 9015
-streaming.spark.service true -streaming.thrift false -streaming.enableHiveSupport true -streaming.udf.clzznames "streaming.crawler.udf.Functions,str
eaming.dsl.mmlib.algs.processing.UDFFunctions"