package uy.edu.ude.myapplication

import android.os.Build
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowActivity


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class LoginRobolectricTest {
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun givenValidCredentials_whenLogin_thenGetIntentWithUsername() {
        onView(withId(R.id.edNombre)).perform(typeText("user"))
        onView(withId(R.id.edPassword)).perform(typeText("pass"))

        onView(withId(R.id.btnOk)).perform(click())
        val shadowActivity: ShadowActivity = Shadows.shadowOf(rule.activity)
        val actualIntent = shadowActivity.nextStartedActivity

        assertThat(actualIntent.getStringExtra("nombre")).isEqualTo("user");
    }

}