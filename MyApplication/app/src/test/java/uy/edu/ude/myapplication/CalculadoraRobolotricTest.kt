package uy.edu.ude.myapplication

import android.app.Application
import android.os.Build
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class CalculadoraRobolotricTest {

    @get:Rule
    val rule = ActivityTestRule(CalculadoraActivity::class.java)

    @Test
    @Ignore("Habilitar cuando Robolectric soporte input de tipo number")
    fun whenSumar_thenGetResult() {
        //Arrange - Preparación
        onView(withId(R.id.edN1)).perform(typeText("2"))
        onView(withId(R.id.edN2)).perform(typeText("2"))

        //Act - Ejecución
        onView(withId(R.id.btnMas)).perform(click())

        //Assert -> Verificación
        onView(withId(R.id.tvResultado)).check(matches(withText("4")))
    }
}