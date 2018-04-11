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
        var single = 0
        var signleSign = ""
        while (sc.hasNextLine()) {
            val line = sc.nextLine()
            var i = line[0]
            j = 1
            for (k in line.substring(1, line.length)) {
                if (k == i && j < 9)
                    j++
                else {
                    if(j == 1){
                        single++
                        signleSign += i.toString()
                        i = k
                    }
                    else{
                        if (single > 0) {
                            result += "-" + single.toString() + signleSign
                            single = 0
                            signleSign = ""
                        }
                        result += j.toString() + i
                        j = 1
                        i = k
                    }
                }
            }
            if(j == 1){
                signleSign += i.toString()
                single++
            }

            if (single > 0) {
                result += "-" + single.toString() + signleSign
                single = 0
                signleSign = ""
            }
            if(j > 1)
              result += j.toString() + i

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
                if (i in '1'..'9')
                    count += 1
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
        z(".\\input\\input3.txt", "output3.txt")
        z(".\\input\\input1.txt", "output1.txt")
        /*println("Введите команду, путь к исходному файлу и имя выходного файла через точку с запятой")
        val list = (readLine() + "").split("; ")
        when (list[0]) {
            "z" -> z(list[1], list[2])
            "u" -> u(list[1], list[2])
            else -> println("Несуществующая команда")
        }*/
    }
}
