object Trait1 {
  def main(args: Array[String]){
    val man = new Man
    man.sayName()
  }
}

trait Human {
  val name = "飛行機"

  def sayName() {
    println("My name is " + name)
  }
}

class Man extends Human
