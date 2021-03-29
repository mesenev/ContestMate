import com.beust.klaxon.Klaxon
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors
import org.python.util.PythonInterpreter

//object JythonHelloWorld {
//    @JvmStatic
//    fun rtp(args: Array<String>) {
//        PythonInterpreter().use { pyInterp -> pyInterp.exec("print('Hello Python World!')") }
//    }
//}
fun main(args: Array<String>) {

    if (result != null) {
        println(result.name)
    }
    assert(result?.name == "John Smith")
    if (result != null) {
        assert(result.age == 23)

//        val s = "C:/Users/plose/IDEshechka/src/main"
//        val command = "python3 $s/script.py"
//        println("Command: $command")
//        val process = Runtime.getRuntime().exec(command)
//        process.waitFor()
//        val reader = BufferedReader(InputStreamReader(process.inputStream))
//        val message = reader.lines().collect(Collectors.joining("\n"))
//        println(message)

    }
}
class Person (val name: String, var age: Int = 23)
val result = Klaxon()
    .parse<Person>("""
    {
      "name": "John Smith",
    }
    """)
