package ude.edu.uy.ejemplosharedpreferences.preference

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje
import ude.edu.uy.ejemplosharedpreferences.main.view.PrincipalActivity

@RunWith(AndroidJUnit4::class)
class FilePreferenceIntegrationTest {
    @get:Rule
    val rule = ActivityTestRule(PrincipalActivity::class.java)

    @Before
    fun setup() {
        val preference = FilePreference(rule.activity, "testPreferences", Context.MODE_PRIVATE)
        preference.save(Puntaje("max", 23))
    }

    @Test
    fun whenFindById_thenGetUsuario() {
        val preference = FilePreference(rule.activity, "testPreferences", Context.MODE_PRIVATE)
        val expected = Puntaje("max", 23)

        val found = preference.getPreferenciaByClave("max", 0)

        assertThat(found).isNotNull().isEqualTo(expected)
    }
}