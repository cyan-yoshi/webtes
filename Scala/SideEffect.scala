object SideEffect{
  var total = 0
  
  def main(args: Array[String]){
    var add = (x:Int) => {
      total += x
      total
    }
    
    printf("total=%s \n",add(1))
    printf("total=%s \n",add(1))
    printf("total=%s \n",add(1))
  }
}

