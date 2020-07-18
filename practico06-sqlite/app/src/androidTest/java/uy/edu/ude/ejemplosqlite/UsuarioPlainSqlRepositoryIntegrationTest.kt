package uy.edu.ude.ejemplosqlite

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.persistence.DbHelper
import uy.edu.ude.ejemplosqlite.repository.UsuarioPlainSqlRepository

@RunWith(AndroidJUnit4::class)
class UsuarioPlainSqlRepositoryInstrumentedTest {

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val dbHelper = DbHelper(context, "testDB", null, 1)
        val repository = UsuarioPlainSqlRepository(dbHelper)
        repository.save(Usuario(1, "Test"))
    }

    @Test
    fun whenFindById_thenGetUsuario() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val dbHelper = DbHelper(context, "testDB", null, 1)
        val repository = UsuarioPlainSqlRepository(dbHelper)
        val expected = Usuario(1, "Test")

        val found = repository.findById(1)

        assertThat(found).isNotNull().isEqualTo(expected)
    }

    @After
    fun tearDown() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val dbHelper = DbHelper(context, "testDB", null, 1)
        val repository = UsuarioPlainSqlRepository(dbHelper)

        repository.deleteById(1)
    }
}