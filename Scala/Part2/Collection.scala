object Collection {
  def main(args:Array[String]){
    val list = List(1,2,3)
    val set = Set(1,2,3)
    val map = Map(1->"red",2->"blue",3->"black")

    printf("List: %s\n",list)
    printf("head: %s\n",list.head)
    printf("tail: %s # ",list.tail)
    println("先頭(head) を除いたリスト")
    printf("tail.head: %s\n",list.tail.head)
    println()
    printf("Set: %s # ",set)
    println("集合")
    printf("contains(1): %s # ",set.contains(1))
    println("1 が含まれているかどうか")
    printf("contains(4): %s # ",set.contains(4))
    println("4 が含まれているかどうか")
    println()
    printf("Map: %s\n",map)
    printf("map(1): %s\n",map(1))
    printf("map(2): %s\n",map(2))
    
  }
}
