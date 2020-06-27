package uy.edu.ude.myapplication

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

//import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        //assertEquals(4, 2 + 2)
        assertThat(2 + 2).isEqualTo(4)
    }

    @Test
    fun dunno() {

    }
}
