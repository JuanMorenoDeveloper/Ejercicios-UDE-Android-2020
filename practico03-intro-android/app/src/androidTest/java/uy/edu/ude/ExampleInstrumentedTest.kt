package uy.edu.ude

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
        assertEquals("uy.edu.ude", appContext.packageName)
    }

    @Test
    fun givenValidInput_whenClickOnBtnHello_thenShowHello() {
        val validInput = "Test"
        Espresso.onView(ViewMatchers.withId(R.id.edText)).perform(typeText(validInput)).perform(closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.btnHello)).perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.tvHello))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hola $validInput")))
    }

    @Test
    fun givenInvalidInput_whenClickOnBtnHello_thenShowError() {
        val invalidInput = "invalidInput"
        //ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.edText)).perform(typeText(invalidInput)).perform(closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.btnHello)).perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.edText))
            .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Entrada incorrecta")))
    }

}
