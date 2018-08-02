object HelloWorld{
      def main(args: Array[String]){
        if(args.size == 0) {
          val strs = Array("Hello", "World","\n")
          output(strs)
        } else {
          printf("Invalid args.")
        }
      }

      def output(strs: Array[String]){
        //foreach: for文 引数に関数を渡すことができる
        //_ : プレイスホルダー_に要素の値を設定する。引数の関数を呼び出す。
        strs.foreach(printf("%s ",_))
      }
}
