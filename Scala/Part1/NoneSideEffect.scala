object NoneSideEffect{
  def main(args: Array[String]){
    var add = (x: Int) => x + 5 : Int

    printf("add=%s \n",add(1))
    printf("add=%s \n",add(1))
    printf("add=%s \n",add(1))
  }
}
