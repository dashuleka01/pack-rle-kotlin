import java.io.*
import java.util.Scanner

object main {
    fun z(text: String, outputfile: String) {
        val fr = FileReader(text)
        val file = File(outputfile)
        val fw = FileWriter(file)
        val sc = Scanner(fr)
        var result = ""
        var j = 1
        while (sc.hasNextLine()) {
            val line = sc.nextLine()
            var i = line[0]
            j = 1
            for (k in line.substring(1, line.length)) {
                if (k == i)
                    j++
                else {
                    result += j.toString() + i
                    j = 1
                    i = k
                }
            }
            result += j.toString() + i
            j = 1

        }
        fw.write(result)

        fr.close()
        fw.close()
    }

    fun u(text: String, outputfile: String) {
        val fr = FileReader(text)
        val file = File(outputfile)
        val fw = FileWriter(file)
        val sc = Scanner(fr)
        var result = ""
        var count = 0

        while (sc.hasNextLine()) {
            for (i in sc.nextLine()) {
                if (i.toString().contains(Regex("""[0-9]""")))
                    count = count * 10 + i.toString().toInt()
                else {
                    for (j in 0..count - 1)
                        result += i.toString()
                    count = 0
                }
            }
        }
        fw.write(result)

        fr.close()
        fw.close()
    }


    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Введите команду, путь к исходному файлу и имя выходного файла через точку с запятой")
        val list = (readLine() + "").split("; ")
        when (list[0]) {
            "z" -> z(list[1], list[2])
            "u" -> u(list[1], list[2])
            else -> println("Несуществующая команда")
        }
    }
}
