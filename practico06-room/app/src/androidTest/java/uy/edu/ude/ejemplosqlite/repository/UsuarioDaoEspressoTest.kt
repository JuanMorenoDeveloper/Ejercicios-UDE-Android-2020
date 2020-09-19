package uy.edu.ude.ejemplosqlite.repository

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.isNotNull
import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.persistence.AppDatabase
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class UsuarioDaoEspressoTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var usuarioDao: UsuarioDao
    private lateinit var db: AppDatabase


    @Test
    @Throws(Exception::class)
    fun getAllUsers() {
        val usuarios = runBlocking { usuarioDao.findAll() }

        assertThat(usuarios, isNotNull())
    }


    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        usuarioDao = db.usuarioDao()
        runBlocking {
            usuarioDao.save(Usuario(1, "Julio"))
        }
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}