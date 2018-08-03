class User(val id:Long, val firstname: String, val lastname: String,
          val fullname:Fullname = new Fullname){
            //fullname:Fullname = new Fullname の = new Fullname はデフォルト値
            def getFullName() = this.fullname.get(firstname,lastname)
          }

class Fullname() {
  def get(firstname:String,lastname:String) =firstname + " " + lastname
}

class FullnameInJapan() extends Fullname {
  override def get(firstname: String,lastname: String) = lastname + " " + firstname
}

object User {
  def main(args: Array[String]){
    val user1 = new User(1,"太郎","田中",new FullnameInJapan)
    //4 つ目の引数が指定されているのでデフォルト値ではないものが使用されている

    val user2 = new User(2,"太郎","田中")
    //user2 では 4 つ目の引数はデフォルト値が使われている

    printf("日本的(override): %s\n",user1.getFullName())
    printf("外国的(default): %s\n",user2.getFullName())
  }
}
