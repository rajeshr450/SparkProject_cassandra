package com.rajuri.hiveandmysql

import java.util.Properties

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object ExportToMySqlDemo {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession.builder().appName("demo").master("local").getOrCreate()

    val url = "jdbc:mysql://192.168.0.103:3306"
    val table = "rajesh.applestock"
    val props = new Properties()
    props.put("user","root")
    props.put("password","hadoop")

    Class.forName("com.mysql.cj.jdbc.Driver")

    val df = spark.read.option("inferSchema","true")
      .option("header","true")
      .csv("C:\\Users\\Rajesh\\IdeaProjects\\SparkPractice\\in\\applestock_2013.csv")

    df.write.jdbc(url,table,props)

  }

}
