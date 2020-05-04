/*
import org.apache.spark.sql.{SaveMode, SparkSession}
import com.mongodb.spark._
import org.apache.log4j._

object MongoSparkDemo {


  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    System.setProperty("org.mongodb.async.type", "netty")

    // val url = "mongodb+srv://rocky:Raja.1252@rajuri-v2vqx.mongodb.net/sample_airbnb?retryWrites=true&w=majority"
    val spark = SparkSession.builder()
      .appName("mongo db spark connector program")
      .master("local[*]")
      .config("spark.mongodb.input.uri","mongodb+srv://test:test@rajuri-v2vqx.mongodb.net/sample_airbnb.listingsAndReviews?retryWrites=true&w=majority")
      .config("spark.mongodb.output.uri","mongodb+srv://test:test@rajuri-v2vqx.mongodb.net/recommendation.ratings")
      .getOrCreate()

//    val df = spark.read.format("com.mongodb.spark.sql.DefaultSource")
//      .load()
    val ratings = spark.read.option("inferSchema","true").option("header","true").csv("C:\\Users\\Rajesh\\Downloads\\ml-latest-small\\ratings.csv")
//    ratings.printSchema()
    ratings.write.format("com.mongodb.spark.sql.DefaultSource")
      .mode(SaveMode.Append)
      .save()


  }


}
*/