import Utilities.YelpReviewsSchema
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.types.LongType
import Utilities._

object ExerciseOne extends App{
  System.setProperty("hadoop.home.dir", "C:/winutils")

  Utilities.setupLogging()
// Create --------------------------------------------------
  val spark = SparkSession
    .builder()
    .appName("YelpReviews")
    .master("local[*]")
    .getOrCreate()

  val firstDataFrame = spark
    .read
    .format("json")
    //    .option("inferSchema", "true")
    .schema(YelpReviewsSchema)
    .load("data/yelp.json")

  //  firstDataFrame.show()
  //  firstDataFrame.printSchema()
//end of create---------------------------------------------------------------------


  // # Use SQL query with spark -----------------------------------------------------
  firstDataFrame.createOrReplaceTempView("table")
  val sqlDF = spark.sql("SELECT * FROM table where city = 'Toronto' ")
//  sqlDF.show()

  // # filter test -------------------------------------------------------------------
  val df = firstDataFrame
//  val df1 = df.filter(not(df("c2")==="MSL")&&not(df("c2")==="HCP"))
//  df.filter(df("city").startsWith("T")).show(10, false)
  df.filter(col("city").contains("Toronto")).show(10, false)
  println(df.count())
//  val strings = spark.read.text("../README.md")
//  val filtered = strings.filter(col("value").contains("Spark"))
//  filtered.count()



}
