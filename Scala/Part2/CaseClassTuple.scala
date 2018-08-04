object CaseClassTuple {
  def get() = {
    val name = new Name("清見","椿山")
    (Human(name,15),name)
  }

  def main(args: Array[String]){
    val tuple = get()
    printf("fullname_1=%s \n",tuple._1.name.fullname)
    printf("fullname_2=%s \n",tuple._2.fullname)
  }
}

class Name(first: String,last: String){
  def fullname() =  first + " " + last
}

case class Human(name: Name,age:Int)

