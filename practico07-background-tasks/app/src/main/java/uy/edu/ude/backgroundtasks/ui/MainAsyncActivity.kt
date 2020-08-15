package uy.edu.ude.backgroundtasks.ui

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main_async.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import uy.edu.ude.backgroundtasks.R
import uy.edu.ude.backgroundtasks.logic.TimerTask
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainAsyncActivity : AppCompatActivity(), MainViewAsync {
    private val executor: ExecutorService = Executors.newFixedThreadPool(4)
    private lateinit var task: TimerTask
    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async)
        task = TimerTask(this, executor)
        initUiComponents()
    }

    private fun initUiComponents() {
        btnOk.setOnClickListener {
            btnOk.visibility = GONE
            btnCancel.visibility = VISIBLE
            showBar()
            job = lifecycleScope.launch {
                task.doInBackground2()
            }
            //GlobalScope.launch(Dispatchers.Main) { task.doInBackground2() }
            //task.doInBackground()
        }
        btnCancel.setOnClickListener {
            btnOk.visibility = VISIBLE
            btnCancel.visibility = GONE
            //task.stop()
            job.cancel()
            Toast.makeText(this, "Tarea cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showBar() {
        pbNumeric.visibility = VISIBLE
    }

    override fun incrementProgress(progress: Int) {
        Log.i("MainAsyncActivity", "incrementProgress ${Looper.getMainLooper().isCurrentThread}  ")
        pbNumeric.progress = progress
    }

    override fun hideBar() {
        pbNumeric.visibility = INVISIBLE
    }

}
