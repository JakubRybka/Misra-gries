import scala.io._
import scala.math._
import scala.util.control._

object Misra-Gries {
  def main(args: Array[String]): Unit = {
    if (args.length>0) {
      //reading file
      val file = args(0)
      val fileSource = Source.fromFile(file)
      val words = fileSource.mkString.split("\\W+").map(_.toLowerCase).toList
      fileSource.close()

      //Defining variables
      val m = words.length
      val k = 21
      val n = m/k
      val Keys = Array.fill(m)("")
      val Values = Array.fill(m)(0)
      val loop = new Breaks
      //break the loop at proper time, where either word was found, or empty space for it Values and Keys
      for(word <- words) //Going through all words in text
      {
        var con = false //False - word isn't in Keys and there is no place for new, True - Values and Keys updated
        loop.breakable(
          for(l<-0 until k) { //Loop to check Keys and Values
            if (Keys(l) == word) {
              Values(l) = Values(l) + 1
              con = true
              loop.break //We stop the second for loop.
            }
            else {
              if (Values(l) == 0) {
                Keys(l) = word
                Values(l) = 1
                con = true
                loop.break //We stop the second for loop.
              }
            }
          })
        if(!con) //Subtracting one from every value if keys and values not updated
          for (j <- 0 until k) {
            if(Values(j)==0)
            {

            }
            else{
              Values(j) = Values(j) - 1
            }
            if (Values(j) == 0) {
              //We delete the redundant word
              Keys(j) = ""
            }
          }
      }

      //sort keys and values and print the table
      val kv = Keys.zip(Values).sortBy(-_._2)
      val pairs = words.groupBy(identity).view.mapValues(_.length).toList.sortBy(-_._2)
      val (w, f) = pairs.unzip
      def yorn (A: Double, B: Double): Boolean ={
        if(A>B){return true}
        else {return false}
      }
      def theoretical(A: Double, B: Double, C:Double): Boolean ={
        //I define the method, which check if the generalized mean inequalities are fulfilled.
        if(A <= B & B <= C){
          return true
        }
        else{
          return false
        }
      }
      println("word ", "fl ", "fl - m/k ", "fl* ", "fl>m/k?", "fl-m/k <= fl* <= fl?")
      for(i<-0 until k)
      {
        println(f"${kv(i)._1} | ${f(i)} | ${f(i)-n} | ${kv(i)._2} | ${yorn(f(i),n)} | ${theoretical(f(i)-n,kv(i)._2, f(i))}")
      }
    }
  }
}