import java.io.File

object IfTest1 {

  def main(args: Array[String]): Unit = {
    var filename = "config.txt"

    if (!args.isEmpty)
      filename = args(0)

    println("FileName: " + filename)

    val refactorfilename = if(args.isEmpty)"config.txt" else args(0)
    println("FileName: " + refactorfilename)
  }
}
