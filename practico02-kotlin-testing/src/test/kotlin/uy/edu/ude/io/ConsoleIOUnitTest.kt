package uy.edu.ude.io

import org.assertj.core.api.Assertions.assertThat
import org.junit.AfterClass
import org.junit.Test
import uy.edu.ude.external.io.Console
import uy.edu.ude.external.io.Reader
import uy.edu.ude.external.io.Writer
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ConsoleIOUnitTest {

    @Test
    fun givenText_whenPrint_thenPrintText() {
        val expectedTest = "Hello from Kotlin"
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        val console: Writer = Console()

        console.write(expectedTest)
        out.flush()
        val printedText = String(out.toByteArray())

        assertThat(printedText).isEqualTo(expectedTest)
    }

    @Test
    fun givenInput_whenRead_thenReadInt() {
        val expectedInt = "45"
        val input = ByteArrayInputStream(expectedInt.toByteArray())
        System.setIn(input)
        val console: Reader = Console()

        val readInt = console.readInt()

        assertThat(readInt).isEqualTo(expectedInt.toInt())
    }

    companion object {
        @AfterClass
        fun resetIO() {
            System.setOut(System.out)
            System.setIn(System.`in`)
        }
    }
}