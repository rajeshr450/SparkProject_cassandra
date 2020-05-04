package com.rajuri.hiveandmysql

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object ExportToHiveDemo extends App{

//  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder()
    .master("local")
    .appName("export to hive")
    .config("spark.sql.warehouse","hdfs://192.168.0.103:8020/user/hive/warehouse/")
    .enableHiveSupport()
    .getOrCreate()

  println("==================process started=============")







}
