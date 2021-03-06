object Literal {
  def main(args: Array[String]){
    //10 進数
    val dec = 24
    println("dec: " + dec)

    //16 進数
    val hex = 0x24
    println("hex: " + hex)

    //Long
    val prog = 35L
    println("prog: " + prog)

    //浮動小数点
    val big = 1.2
    println("big: " + big)

    val bigger = 1.2e2
    println("bigger: " + bigger)

    val biggerStill = 1.2e45
    println("biggerStill: " + biggerStill)

    val little = 1.2f
    println("little: " + little)

    //文字列リテラル
    val a = "あ"
    println("a: " + a)

    val name = "田沢 慎一郎"
    println("name: " + name)

    val sentence = """"|Test test
    |test "test"""".stripMargin
    println("sentence: " + sentence)

    //真偽値リテラル
    val bool = true
    println("bool: " + bool)

    //シンボルリテラル
    val s = 'synbolA
    println("s: " + s.name)
  }
}

