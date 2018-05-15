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
        main(arrayOf("-u", "input2.txt", "-out", "abc.txt")) //распаковка
        assertFileContent("abc.txt",
                "bbaaakkkkkhjki")
        File("abc.txt").delete()

        main(arrayOf("-z", "input3.txt")) //упаковка
        assertFileContent("input3.txt.out",
                "9a4b5k-9tnfjik6h0-3kjw")
        File("input3.txt.out").delete()
    }
}