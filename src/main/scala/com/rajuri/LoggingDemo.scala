package com.rajuri

import org.apache.log4j.{Level, LogManager, Logger}
import org.apache.spark.rdd.RDD

object LoggingDemo {
  //  Logger.getLogger("org").setLevel(Level.WARN)


  def my_count(in_rdd: RDD[(Int,String)]): Long = {
    //spark.sparkContext.setLogLevel("WARN")
    val log1: Logger = LogManager.getLogger(this.getClass.getName)
    log1.setLevel(Level.INFO)
    log1.info("entered into another object")
    in_rdd.count()
  }
}

