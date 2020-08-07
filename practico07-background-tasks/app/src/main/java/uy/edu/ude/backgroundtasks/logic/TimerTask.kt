package uy.edu.ude.backgroundtasks.logic

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import uy.edu.ude.backgroundtasks.ui.MainViewAsync
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.atomic.AtomicBoolean

class TimerTask(
    val view: MainViewAsync,
    val executor: ExecutorService
) {
    private val running: AtomicBoolean = AtomicBoolean(false)

    fun doInBackground() {
        executor.execute {
            running.set(true)
            for (i in 1..100) {
                if (running.get()) {
                    Log.i("TimerTask", "Execution $i")
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                    }
                    val url = URL("https://gturnquist-quoters.cfapps.io/api/random")
                    (url.openConnection() as? HttpURLConnection)?.run {
                        requestMethod = "GET"
                        setRequestProperty("Content-Type", "application/json; charset=utf-8")
                        setRequestProperty("Accept", "application/json")
                        val input = Scanner(InputStreamReader(inputStream))
                        val result = StringBuilder()
                        while (input.hasNextLine()) {
                            result.append(input.nextLine())
                        }
                        Log.i("TimerTask", result.toString())
                    }
                    view.incrementProgress(i)
                } else {
                    break
                }
            }
            view.hideBar()
        }
    }

    suspend fun doInBackground2() {
        withContext(Dispatchers.IO) {
            for (i in 1..100) {
                if (isActive) {
                    Log.i("TimerTask", "Execution $i")
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                    }
                    val url = URL("https://gturnquist-quoters.cfapps.io/api/random")
                    (url.openConnection() as? HttpURLConnection)?.run {
                        requestMethod = "GET"
                        setRequestProperty("Content-Type", "application/json; charset=utf-8")
                        setRequestProperty("Accept", "application/json")
                        val input = Scanner(InputStreamReader(inputStream))
                        val result = StringBuilder()
                        while (input.hasNextLine()) {
                            result.append(input.nextLine())
                        }
                        Log.i("TimerTask", result.toString())
                    }
                    view.incrementProgress(i)
                } else {
                    break
                }
            }
        }
    }

    fun stop() {
        running.set(false)
    }
}