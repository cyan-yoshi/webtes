// var の変数定義では値を変更できることを確認する。
object Mutable{
  def main(args: Array[String]){
    var mutable = "Mutable"
    printf("%s \n",mutable)

    mutable = "Change mutable"
    printf("%s \n",mutable)
  }
}
