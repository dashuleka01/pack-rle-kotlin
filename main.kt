import java.io.*
import java.util.Scanner
import kotlin.system.exitProcess

fun z(text: String) {
    z(text, text + ".out")
}

fun z(text: String, out: String) {
    val fr = FileReader(text)
    val file = File(out)
    val fw = FileWriter(file)
    val sc = Scanner(fr)

    var j = 1
    var single = 0
    var signleSign = StringBuilder()

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
                    signleSign.append(i.toString())
                    i = k
                    if (single == 9) {
                        fw.write("-" + single.toString() + signleSign)
                        single = 0
                        signleSign.delete(0, signleSign.length)
                    }
                } else {
                    if (single > 0) {
                        fw.write("-" + single.toString() + signleSign)
                        single = 0
                        signleSign.delete(0, signleSign.length)
                    }
                    fw.write(j.toString() + i)
                    j = 1
                    i = k
                }
            }
        }

        if (single == 9) {
            fw.write("-" + single.toString() + signleSign)
            single = 0
            signleSign.delete(0, signleSign.length)
        }

        if (j == 1) {
            signleSign.append(i.toString())
            single++
        }

        if (single > 0) {
            fw.write("-" + single.toString() + signleSign)
            single = 0
            signleSign.delete(0, signleSign.length)
        }

        if (j > 1)
            fw.write(j.toString() + i)
    }

    fr.close()
    fw.close()
}

fun u(text: String) {
    u(text, text + ".out")
}

fun u(text: String, out: String) {

    var output = ""
    if (out == "") {
        output = text + "out"
    } else {
        output = out
    }

    val fr = FileReader(text)
    val file = File(output)
    val fw = FileWriter(file)
    val sc = Scanner(fr)

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
                        fw.write(i.toString())
                        count--
                    }
                    if (count == 0)
                        flag = false
                } else {
                    if (count == 0) { //кол-во символов
                        count = i.toString().toInt()
                    } else {
                        for (j in 1..count) {
                            fw.write(i.toString())
                        }
                        count = 0
                    }
                }
            }
        }
    }

    fr.close()
    fw.close()
}


fun main(args: Array<String>) {
    try {
        if (args.size == 4 && args[2] == "-out") {
            when (args[0]) {
                "-z" -> z(args[1], args[3])
                "-u" -> u(args[1], args[3])
                else -> println("Неверный аргумент")
            }
        } else if (args.size == 2){
            when (args[0]) {
                "-z" -> z(args[1])
                "-u" -> u(args[1])
                else -> println("Неверный авргумент")
            }
        }
        else {
            println("Неверное количество аргументов")
        }
    } catch (e: FileNotFoundException) {
        println("Неверный файл")
    }
    catch (e: NumberFormatException){
        println("Неверные данные")
    }
}