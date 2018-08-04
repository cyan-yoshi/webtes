object Tuple23 {

  def get() = {
    (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)
  }

  def main(args: Array[String]){
    val tuple = get()
    printf("element_1=%s \n",tuple._1)
    printf("element_22=%s \n",tuple._23)
  }
}
