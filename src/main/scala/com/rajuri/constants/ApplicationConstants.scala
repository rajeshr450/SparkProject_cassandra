package com.rajuri.constants

object ApplicationConstants extends Enumeration {
  val APP_NAME = Value("app.name")
  val CASSANDRA_CONNECTION_HOST = Value("cassandra.host")
  val CASSANDRA_CONNECTION_PORT = Value("cassandra.port")
  val CASSANDRA_CONNECTION_KEYSPACE = Value("cassandra.connection.keyspace")
  val CASSANDRA_CONNECTION_TABLE = Value("cassandra.connection.table")
  val APPLICATION_LOG_FILE_LOCATION = Value("log.file.location")
  val ENV = Value("env")
}
