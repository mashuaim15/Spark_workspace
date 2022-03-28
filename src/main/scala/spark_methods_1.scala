//import ExerciseOne.spark
//import spark.implicits._
//import ExerciseOne.firstDataFrame
//
//case class Characters(name: String, id: Int)
//val data = Seq(Characters("Jon", 21), Characters("Tyrion", 22), Characters("Gandalf", 19))
//val ds = spark.createDataset(data)
//
////To read data from a Datasource
//val path = "examples/src/main/resources/Characters.csv"
//val peopleDS = spark.read.csv(path).as[Characters]
//peopleDS.filter(_.id%2 ==0).show()
//
//val ds1 = firstDataFrame.as[Characters]
//ds1.filter(_.name.startsWith("J")).show()
