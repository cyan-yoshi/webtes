object FirstClassFunction{
  def main(args: Array[String]){
    val add = (x: Int) => {
      val _add = (y: Int) => y + 5
      _add(x)
    }

    val add2 = (x:Int,y:Int) => {//関数リテラル
      val tmp = x + y :Int
      tmp
    }

    def add3(x:Int,y:Int) = x+y//メソッド
      
      

    printf("add=%s \n",add(1))
    printf("add=%s \n",add(2))
    printf("add=%s \n",add(1))
    printf("add2=%s \n",add2(1,3))
    printf("add3=%s \n",add3(10,32))
  }
}
