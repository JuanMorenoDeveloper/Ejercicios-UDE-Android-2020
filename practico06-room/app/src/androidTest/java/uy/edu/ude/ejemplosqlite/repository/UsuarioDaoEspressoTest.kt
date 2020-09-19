package uy.edu.ude.ejemplosqlite.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
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
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}