package com.rajuri.cassandra

import com.rajuri.utils.CassandraMasterUtility
import org.apache.spark.sql.SparkSession


object CassandraMasterApp extends App {

  val spark = SparkSession.builder().appName("demo").master("local").getOrCreate()
//  val spark = CassandraMasterUtility.getOrCreateSparkSession()

  println("hello")

}
