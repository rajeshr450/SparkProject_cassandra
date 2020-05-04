package com.rajuri.logging

import com.rajuri.constants.ApplicationConstants
import org.apache.log4j.{Level, Logger, PatternLayout}
import com.rajuri.utils.CassandraMasterUtility

object InitiateLogger {

  var logger :Option[Logger] = None

  def getLogger:Logger = {
    if(logger == None){
      logger = Some(Logger.getRootLogger)
      logger.get.setLevel(Level.INFO)
      val layout = new PatternLayout("%d{yyyy-mm-dd HH:mm:ss} %-5p %c{1}:%L - %m%n")
      val confDetails = CassandraMasterUtility.getConfDetails
      val customLogging = new CustomLogging
      customLogging.setLayout(layout)
      customLogging.setFile(confDetails(ApplicationConstants.APPLICATION_LOG_FILE_LOCATION.toString))
      customLogging.activateOptions()
      logger.get.addAppender(customLogging)
    }
    logger.get
  }

}
