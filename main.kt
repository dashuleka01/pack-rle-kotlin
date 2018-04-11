import java.io.*
import java.util.Scanner


fun z(text: String) {
    val fr = FileReader(text)
    val output = "output" + text
    val file = File(output)
    val fw = FileWriter(file)
    val sc = Scanner(fr)

    var result = ""
    var j = 1
    var single = 0
    var signleSign = ""
    var text = ""

    while (sc.hasNextLine()) {
        val line = sc.nextLine()
        text += line
        var i = line[0]
        j = 1
        for (k in line.substring(1, line.length)) {
            if (k == i && j < 9)
                j++
            else {
                if (j == 1) {
                    single++
                    signleSign += i.toString()
                    i = k
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
        if (j == 1) {
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

    if (result.length <= text.length)
        fw.write(result)
    else
        fw.write(text)

    fr.close()
    fw.close()
}

fun u(text: String) {
    val fr = FileReader(text)
    val output = "output" + text
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
}


fun main(args: Array<String>) {
    when (args[0]) {
        "z" -> z(args[1])
        "u" -> u(args[1])
        else -> println("Несуществующая команда")
    }
}