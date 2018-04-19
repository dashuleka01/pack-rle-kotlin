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
        try {
            main(arrayOf("-u", "input1.txt"))
            fail("Illegal Argument")
        } catch (e: IllegalArgumentException) {
        }

        main(arrayOf("-u", "input2.txt", "abc")) //распаковка
        assertFileContent("input2.abc",
                "bbaaakkkkkhjki")
        File("input2.abc").delete()

        main(arrayOf("-z", "input3.txt")) //упаковка
        assertFileContent("input3.output",
                "7a4b5k-9tnfjik6h0-1k")
        File("input3.output").delete()
    }
}