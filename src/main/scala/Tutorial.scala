import Utilities._
import org.apache.spark.sql.SparkSession


object Tutorial extends App {
  System.setProperty("hadoop.home.dir", "C:/winutils")

  Utilities.setupLogging()
  val spark = SparkSession
    .builder()
    .appName("InstrumentReviews")
    .master("local[*]")
    .getOrCreate()

  val firstDataFrame = spark
    .read
    .format("json")
//    .option("inferSchema", "true")
    .schema(instrumentReviewsSchema)
    .load("data/InstrumentReviews.json")

  firstDataFrame.show()
  firstDataFrame.printSchema()


}