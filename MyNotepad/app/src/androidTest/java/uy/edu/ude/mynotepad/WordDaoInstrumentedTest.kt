package uy.edu.ude.mynotepad

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uy.edu.ude.mynotepad.entities.Word
import uy.edu.ude.mynotepad.usecases.WordDao
import uy.edu.ude.mynotepad.usecases.WordRoomDatabase
import uy.edu.ude.mynotepad.usecases.waitForValue

@RunWith(AndroidJUnit4::class)
class WordDaoInstrumentedTest {

    @get:Rule
    val instant = InstantTaskExecutorRule()//Solo para liveData

    private lateinit var wordDao: WordDao
    private lateinit var db: WordRoomDatabase

    @Before
    fun init() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        db = Room.inMemoryDatabaseBuilder(context, WordRoomDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        wordDao = db.wordDao()
    }

    @Test
    fun whenQueryWord_thenGetResult() {
        val word = Word("Test")

        runBlocking {
            wordDao.insert(word)
        }
        val words = wordDao.getWords()

        assertThat(words).hasSize(1).contains(word)
    }

    @Test
    fun whenGetAlphabetizedWords_thenGetResult() {
        val word = Word("Test")

        runBlocking {
            wordDao.insert(word)
        }
        val words = wordDao.getAlphabetizedWords().waitForValue()

        assertThat(words).hasSize(1).contains(word)
    }

    @Test
    fun whenGetWordByName_thenGetResult() {
        val word = Word("Test")
        val word1 = Word("Test25")
        val word2 = Word("QA25")

        runBlocking {
            wordDao.insert(word)
            wordDao.insert(word1)
            wordDao.insert(word2)
        }
        val words = wordDao.getWordBy("QA25")

        assertThat(words).hasSize(1).contains(word2)
    }


    @After
    fun close() {
        db.close()
    }

}