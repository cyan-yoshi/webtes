class User(val id: Long,val firstname: String,val lastname: String){
  def getFullname() = this.firstname + " " + this.lastname
  }

class User2(private val id: Long,val firstname: String,val lastname: String){
  def getFullname() = this.firstname + " " + this.lastname
  }

object User{
  def main(args: Array[String]){
    val user = new User(1,"源氏","平家")
    println(user.firstname)
    println(user.id)

    val user2 = new User2(2,"田中","太郎")
    println(user2.id)
  }
}

