object Seq {
  def main (args:Array[String]){
    Seq(4,1,2,3).foreach(println(_))

    println(Seq(1,2,3) ++ Seq(4,5))
    val list = Seq(1,2,3) ++ Seq(4,5) 
    println(list.head)
    println()

    val clist = Seq("red","blue","yellow")flatMap(_.toList)
    println(clist)
    println()

    val collect = Seq(1,2,3)collect{case(i) if(i%2==1)=>i}
    println(collect)
    println()
    
    var array = Seq(1,2,3).toArray
    printf("1+2+3 = %s\n",array(0) + array(1)+array(2))
    //println()

    val iterable = Seq(1,2,3).toIterable
    println(iterable)

    val tolist = Seq(1,2,3).toList
    println(tolist)
    
    val tomap = Seq((1,"a"),(2,"b"),(3,"c")).toMap
    println(tomap)

    val toseq = Map(1->"a",2->"b",3->"c").toSeq
    println(toseq)

    val toset = Seq(1,2,3,1).toSet
    println(toset)

    val tostream = Seq(1,2,3,1).toStream
    println(tostream)
    println()

    var array2 = Array(4,5,6,7,8)
    val copytoarray = Seq(1,2,3).copyToArray(array2)
    println(array2(0)+","+array2(1)+","+array2(2)+","+array2(3)+","+array2(4))

    var buffer = scala.collection.mutable.Buffer(4,5,6,7,8)
    val copybuffer = Seq(1,2,3).copyToBuffer(buffer)
    println(buffer)
    println()

    println("Seq(1,2,3).isEmpty: " + Seq(1,2,3).isEmpty)
    println("Seq().isEmpty: " + Seq().isEmpty)
    println("Seq(1,2,3).nonEmpty: " + Seq(1,2,3).nonEmpty)
    println("Seq().nonEmpty: " + Seq().nonEmpty)
    println()

    println("Seq(1,2,3).size: " + Seq(1,2,3).size)
    println()

    print("Seq(1,2,3).find: " + Seq(1,2,3).find(_>1) +" # ")
    println("条件を満たすファーストヒットのみ返却")
    println()

    println("Seq(1,2,3).head: " + Seq(1,2,3).head)
    println("Seq(1,2,3).headOption: " + Seq(1,2,3).headOption)
    println("Seq(1,2,3).tail: " + Seq(1,2,3).tail)
    println()

    println("Seq(1,2,3).last: " + Seq(1,2,3).last)
    println("Seq(1,2,3).lastOption: " + Seq(1,2,3).lastOption)
    print("Seq(1,2,3).init: " + Seq(1,2,3).init+" # ")
    println("last を除いた値のみ返却")
    println()

    print("Seq(1,2,3,4,5).take(2): " + Seq(1,2,3,4,5).take(2)+" # ")
    println("最初の n 個の要素からなるコレクション")
    print("Seq(1,2,3,4,5).drop(2): " + Seq(1,2,3,4,5).drop(2)+" # ")
    println("take を除いた残り")
    println()

    print("Seq(1,2,3,4,5).filter(_%2==1): " + Seq(1,2,3,4,5).filter(_%2==1)+" # ")
    println("filter にマッチするものだけ")
    println("Seq(1,2,3,4,5).filterNot(_%2==1): " + Seq(1,2,3,4,5).filterNot(_%2==1))
    print("Seq(1,2,3,4,5).count(_%2==1): " + Seq(1,2,3,4,5).count(_%2==1)+" # ")
    println("関数にマッチする要素の数")
    println("Seq(1,2,3,4,5).exists(_>4): " + Seq(1,2,3,4,5).exists(_>4))
    print("Seq(1,2,3,4,5).exists(_>5): " + Seq(1,2,3,4,5).exists(_>5)+" # ")
    println("関数にマッチする要素があるかどうか")
    print("Seq(1,2,3,4,5).partition(_>3): " + Seq(1,2,3,4,5).partition(_>3)+" # ")
    println("関数を満たす要素、満たさない要素を Map で返却")
    print("Seq(1,2,3,4,5).span(_%2==1): " + Seq(1,2,3,4,5).span(_%2==1)+" # ")
    println("先頭から関数を満たす要素、満たさなくなってから最後までの要素を Map で返却")
    println()

    print("Seq(1,2,3,4,5).slice(2,4): " + Seq(1,2,3,4,5).slice(2,4)+" # ")
    println("from(2) から to(4) まで = インデックスの 2 番目と 3 番目")
    print("Seq(1,2,3,4,5).splitAt(3): " + Seq(1,2,3,4,5).splitAt(3)+" # ")
    println("n 番目で分割したコレクションのコレクション")
    println()

    print("Seq(1,2,3).foldLeft(10)(_-_): " + Seq(1,2,3).foldLeft(10)(_-_)+" # ")
    println("引数と先頭の要素から順番に演算 (((10-1)-2)-3)")
    print("Seq(1,2,3).foldRight(10)(_-_): " + Seq(1,2,3).foldRight(10)(_-_)+" # ")
    println("末尾の要素と引数から順番に演算 (1-(2-(3-10)))")
    print("Seq(1,2,3).reduceLeft(_-_): " + Seq(1,2,3).reduceLeft(_-_)+" # ")
    println("先頭の要素から順番に演算 ((1-2)-3)")
    print("Seq(1,2,3).reduceRight(_-_): " + Seq(1,2,3).reduceRight(_-_)+" # ")
    println("末尾の要素から順番に演算 (1-(2-3))")
    println("Seq(1,2,3,4,5).sum: " + Seq(1,2,3,4,5).sum)
    print("Seq(1,2,3,4,5).product: " + Seq(1,2,3,4,5).product +" # ")
    println("和と積")
    println("Seq(1,2,3,4,5).min: " + Seq(1,2,3,4,5).min)
    println("Seq(1,2,3,4,5).max: " + Seq(1,2,3,4,5).max)
    println()

    var builder = new StringBuilder 
    builder = Seq(1,2,3).addString(builder)
    print("Seq(1,2,3).addString(builder): " + builder+" # ")
    println("要素を文字列として StringBuilder に追加する")
    print("Seq(1,2,3).mkString(_): " + Seq(1,2,3).mkString("_")+" # ")
    println("要素を区切り文字で連結")
    println()

    print("Seq(1,2,3).view: " + Seq(1,2,3).view+" # ")
    println("view の作成")
  }
}

