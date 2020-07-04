package uy.edu.ude.myapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculadoraInstrumentedTest {

    @get:Rule
    val rule = ActivityTestRule(CalculadoraActivity::class.java)

    @Test
    fun whenSumar_thenGetResult() {
        //Arrange - Preparación
        Espresso.onView(ViewMatchers.withId(R.id.edN1)).perform(ViewActions.typeText("2"))
        Espresso.onView(ViewMatchers.withId(R.id.edN2)).perform(ViewActions.typeText("2"))

        //Act - Ejecución
        Espresso.onView(ViewMatchers.withId(R.id.btnMas)).perform(ViewActions.click())

        //Assert -> Verificación
        Espresso.onView(ViewMatchers.withId(R.id.tvResultado))
            .check(ViewAssertions.matches(ViewMatchers.withText("4")))
    }

    @Test
    fun givenValidN2_whenDivide_thenGetResult() {
        //Arrange - Preparación
        val n1 = "5"
        val n2 = "2"
        val resultExpected = "2.5"
        Espresso.onView(ViewMatchers.withId(R.id.edN1)).perform(ViewActions.typeText(n1))
        Espresso.onView(ViewMatchers.withId(R.id.edN2)).perform(ViewActions.typeText(n2))

        //Act - Ejecución
        Espresso.onView(ViewMatchers.withId(R.id.btnDividir)).perform(ViewActions.click())

        //Assert -> Verificación
        Espresso.onView(ViewMatchers.withId(R.id.tvResultado))
            .check(ViewAssertions.matches(ViewMatchers.withText(resultExpected)))
    }

    @Test
    fun givenInvalidN2_whenDivide_thenGetErrorMsg() {
        //Arrange - Preparación
        val n1 = "5"
        val n2 = "0"
        val resultExpected = rule.activity.getString(R.string.n2_eq_zero_error)
        Espresso.onView(ViewMatchers.withId(R.id.edN1)).perform(ViewActions.typeText(n1))
        Espresso.onView(ViewMatchers.withId(R.id.edN2)).perform(ViewActions.typeText(n2))

        //Act - Ejecución
        Espresso.onView(ViewMatchers.withId(R.id.btnDividir)).perform(ViewActions.click())

        //Assert -> Verificación
        Espresso.onView(ViewMatchers.withId(R.id.tvResultado))
            .check(ViewAssertions.matches(ViewMatchers.withText(resultExpected)))
    }
}