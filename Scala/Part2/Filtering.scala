object Filteling {

  def main (args:Array[String]) {
    val list = List("aa","ba","ca","ab","bb","cb")
    for (name <- list){
      println(name)
    }
    println()
    for (name <- list if name.startsWith("b")){
      println(name)
    }
    println()
    val deniels = for { name <- list if name.startsWith("b")}yield name
    for(name <- deniels){
      println(name)
    }
  }
}



