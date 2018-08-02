//val は変数定義だが、値を変更できないことを確認
//
object Immutable{
  def main(args: Array[String]){
    val immutable = "Immutable"
    printf("%s \n",immutable)

    immutable = "Change immutable"
    printf("%s \n",immutable)
  }
}

