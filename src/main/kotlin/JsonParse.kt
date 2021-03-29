import com.beust.klaxon.Klaxon
import org.python.antlr.ast.Str
import java.io.*
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

//Прога, которая парсит json


data class Data(
    val submit: List<Submit>
)

class JsonParse
fun main(args: Array<String>) {
    //запускает скрипт
    val executable = Runtime.getRuntime().exec("python C:/Users/plose/IDEshechka/test.py")
    println(executable)
    //открывает файл
    val bufferedReader: BufferedReader = File("res.json").bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    println(inputString)
    //Парсит json
    val res = Klaxon().parse<Data>(inputString)
    //обращение к элементу
    if (res != null) {
        println(res.submit[0].content_link)
    }
    println(res)
}