package com.rajuri

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

import org.apache.spark.sql.SparkSession

import scala.collection.JavaConverters._
import scala.collection.mutable

object test extends App {

    val spark = SparkSession.builder().master("local").appName("test").getOrCreate()
  //    val environmentVars = System.getenv().asScala
  //  for ((k,v) <- environmentVars) println(s"key: $k, value: $v")

  val properties = System.getProperties().asScala
  //  for ((k,v) <- properties)
  writeFile("spark-systproperties.txt", lines = properties)
  def writeFile(filename: String, lines: mutable.Map[String, String]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    for ((k, v) <- lines) {
      bw.write(k + " : " + v)
      bw.write("\n")
    }
    bw.close()
  }


}