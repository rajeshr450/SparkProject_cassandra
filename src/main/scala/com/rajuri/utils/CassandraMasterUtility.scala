package com.rajuri.utils

import com.rajuri.constants.ApplicationConstants
import com.rajuri.logging.InitiateLogger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object CassandraMasterUtility {

  def getOrCreateSparkSession(): SparkSession = {
    val logger = InitiateLogger.getLogger
    val confDetails = getConfDetails
    val env = confDetails(ApplicationConstants.ENV.toString)

    val conf = new SparkConf()
      .setAppName("cassandra demo")
      .set("spark.cassandra.connection.host", "")
      .set("spark.cassandra.connection.port", "3042")
      .set("spark.cassandra.auth.username", "cassandra")
      .set("spark.cassandra.auth.password", "cassandra")

    val spark = SparkSession.builder().config(conf).getOrCreate()
    spark
  }

  def stopSparkSession(spark: SparkSession): Unit = {
    spark.stop()
  }

  def getConfDetails: Map[String, String] = {
    lazy val details = ApplicationConstants.values.map { key => (key.toString, System.getProperty(key.toString)) }.toMap
    details
  }

}
