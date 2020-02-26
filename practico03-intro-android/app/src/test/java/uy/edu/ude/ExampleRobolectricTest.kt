package uy.edu.ude

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleRobolectricTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun whenShowActivity_thenTvShowHelloText() {
        onView(withId(R.id.tvHello)).check(matches(withText("Hello World!")))
    }

    @Test
    fun givenValidInput_whenClickOnBtnHello_thenShowHello() {
        val validInput = "Test"
        onView(withId(R.id.edText)).perform(typeText(validInput))

        onView(withId(R.id.btnHello)).perform(click())

        onView(withId(R.id.tvHello)).check(matches(withText("Hola $validInput")))
    }
}