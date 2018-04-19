import java.io.*
import java.util.Scanner


fun z(text: String, out: String) {
    var output = ""
    if (out == "") {
        output = Regex("""\..*$""").replace(text, ".output")
    } else {
        output = Regex("""\..*$""").replace(text, "." + out)
    }
    val fr = FileReader(text)
    val file = File(output)
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
        for (k in line.subSequence(1, line.length)) {
            if (k == i && j < 9)
                j++
            else {
                if (j == 1) {
                    single++
                    signleSign += i.toString()
                    i = k
                    if (single == 9) {
                        result += "-" + single.toString() + signleSign
                        single = 0
                        signleSign = ""
                    }
                } else {
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
        if (j == 1 && single < 9) {
            signleSign += i.toString()
            single++

        }
        if (single > 0) {
            result += "-" + single.toString() + signleSign
            single = 0
            signleSign = ""

        }
        if (j > 1)
            result += j.toString() + i

    }

    fw.write(result)

    fr.close()
    fw.close()
}

fun u(text: String, out: String) {
    try {
        var output = ""
        if (out == "") {
            output = Regex("""\..*$""").replace(text, ".output")
        } else {
            output = Regex("""\..*$""").replace(text, "." + out)
        }

        val fr = FileReader(text)
        val file = File(output)
        val fw = FileWriter(file)
        val sc = Scanner(fr)
        var result = ""
        var flag = false
        var count = 0

        while (sc.hasNextLine()) {
            for (i in sc.nextLine()) {
                if (i == '-') {
                    flag = true
                } else {
                    if (flag) { //одиночные символы
                        if (count == 0)
                            count = i.toString().toInt()
                        else {
                            result += i
                            count--
                        }
                        if (count == 0)
                            flag = false
                    } else {
                        if (count == 0) { //кол-во символов
                            count = i.toString().toInt()
                        } else {
                            for (j in 1..count) {
                                result += i
                            }
                            count = 0
                        }
                    }
                }
            }
        }
        fw.write(result)

        fr.close()
        fw.close()
    }catch (e: Exception){
        throw IllegalArgumentException()
    }


}


fun main(args: Array<String>) {
    if (args.size == 3) {
        when (args[0]) {
            "-z" -> z(args[1], args[2])
            "-u" -> u(args[1], args[2])
            else -> println("Несуществующая команда")
        }
    } else {
        when (args[0]) {
            "-z" -> z(args[1], "")
            "-u" -> u(args[1], "")
            else -> println("Несуществующая команда")
        }
    }
}