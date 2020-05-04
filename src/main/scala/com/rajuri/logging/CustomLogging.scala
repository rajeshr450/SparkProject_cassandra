package com.rajuri.logging

import java.text.SimpleDateFormat
import java.util.Date
import org.apache.log4j.FileAppender

class CustomLogging extends FileAppender {

  override def setFile(file: String): Unit = {
    super.setFile(prependDate(file))
  }

  def prependDate(filename: String): String = {
    val sdf = new SimpleDateFormat("yyyyMMddHHmmss")
    filename + "_" + sdf.format(new Date()) + ".log"
  }
}
