object Trait {
  class Jobclass(name:String){
  }

  trait Jobtrait {
    val name1:String
    val name2="student"

    def getName(){
      println("aaaaa")
    }
  }

  def main(args: Array[String]){
    val res = new Jobtrait{val name1="test"}
    println(res.name1)
    println(res.name2)
    println()

    val res1 = new {val name1 = "student1" } with Jobtrait
    println(res1.name1)
    println(res1.name2)
    res1.getName()
    println()

  }
}


