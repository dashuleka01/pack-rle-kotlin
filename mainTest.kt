import org.junit.Assert.*
import java.io.File

class mainTest {
    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @org.junit.Test
    fun main() {
        main(arrayOf("z", "input1.txt")) //тест, проверяющий сжатие "неудачных" данных
        assertFileContent("outputinput1.txt",
                "qwerty")
        File("outputinput1.txt").delete()

        main(arrayOf("u", "input2.txt")) //распаковка
        assertFileContent("outputinput2.txt",
                "bbaaakkkkkhjki")
        File("outputinput2.txt").delete()

        main(arrayOf("z", "input3.txt")) //упаковка
        assertFileContent("outputinput3.txt",
                "3a2b5k-6tnfjik")
        File("outputinput3.txt").delete()
    }
}