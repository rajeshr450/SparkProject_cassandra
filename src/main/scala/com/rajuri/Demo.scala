package com.rajuri

import org.apache.log4j.{Level, LogManager}
import org.apache.spark.sql.SparkSession

object Demo {


  def main(args: Array[String]): Unit = {

//    Logger.getLogger("org").setLevel(Level.DEBUG)

    val spark = SparkSession.builder().appName("wordcount").master("local").getOrCreate()
//    val log = LogManager.getRootLogger
    val log = LogManager.getLogger(this.getClass.getName)
    log.setLevel(Level.INFO)

    log.info("spark session created")

    val rdd = spark.sparkContext.textFile("C:\\Users\\Rajesh\\Desktop\\test.txt")

    log.info("file is loaded into rdd")

    val words = rdd.flatMap(x => x.split("\\W+"))

    val wordcounts = words.map(x => (x , 1)).reduceByKey(_+_)

    val sortedwordcount = wordcounts.map(x => (x._2,x._1)).sortByKey()

    sortedwordcount.foreach(println)
    println("count of rdd",LoggingDemo.my_count(sortedwordcount))
    log.info("shutting down spark")

    spark.close()

  }

}
