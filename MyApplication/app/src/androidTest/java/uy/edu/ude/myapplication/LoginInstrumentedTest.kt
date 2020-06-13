package uy.edu.ude.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun givenValidCredentials_whenLogin_thenGetWelcomeMessage() {
        onView(withId(R.id.edNombre)).perform(typeText("user")).perform(closeSoftKeyboard())
        onView(withId(R.id.edPassword)).perform(typeText("pass")).perform(closeSoftKeyboard())

        onView(withId(R.id.btnOk)).perform(click())

        onView(withId(R.id.tvNombre)).check(matches(withText("user")))
    }
}