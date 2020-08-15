package uy.edu.ude.myapplication2.main

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import uy.edu.ude.myapplication2.MyApplication
import uy.edu.ude.myapplication2.MyDatabase
import uy.edu.ude.myapplication2.R
import uy.edu.ude.myapplication2.main.presenter.DefaultMainPresenter
import uy.edu.ude.myapplication2.main.presenter.MainPresenter
import uy.edu.ude.myapplication2.main.view.MainView
import uy.edu.ude.myapplication2.usecases.DefaultFillProgress
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), MainView {
    private val myApplication = MyApplication()

    //    private val control = AtomicBoolean(false)
    private lateinit var myDatabase: MyDatabase
    private lateinit var job: CoroutineContext
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUiComponents()
        myDatabase =
            MyDatabase(this, "MyApplication2", null, 1)
        presenter = DefaultMainPresenter(this, DefaultFillProgress(myApplication.executor))
        //control.set(true)
    }

    fun initUiComponents() {
        btnIniciar.setOnClickListener {
            iniciar()
        }
        btnCancelar.setOnClickListener {
            cancelar()
        }
    }

    private fun iniciar() {
        /*job = lifecycleScope.launch {
            //doInBackground()
            cargarDB()
        }*/
        /*GlobalScope.launch {
            doInBackground()
        }*/
        //cargarDB()
        //pbProgreso.max = 500
        presenter.start()
        btnIniciar.visibility = GONE
        btnCancelar.visibility = VISIBLE
    }

    private fun cancelar() {
        presenter.setControl(false)
        //stop()
        //job.cancel()
        btnIniciar.visibility = VISIBLE
        btnCancelar.visibility = GONE
        Log.i("MainActivity", "Tarea Cancelada")
        Toast.makeText(this, "Tarea Cancelada", Toast.LENGTH_LONG).show()
    }

//    fun cargarDB() {
//        myApplication.executor.execute {
//            control.compareAndSet(false, true)
//            val db = myDatabase.writableDatabase
//            db.use { // El use cierra automáticamente el puntero
//                for (i in 1..500) {
//                    if (control.get()) {
//                        db.execSQL("insert into usuario (id,nombre) values ($i,'persona$i') ")
//                        actualizarProgreso(i)
//                    } else {
//                        break
//                    }
//                }
//            }
//        }
//        //db.close()
//    }

    suspend fun doInBackground() {
        withContext(Dispatchers.Default) {
            for (i in 0..100 step 10) {
                if (isActive) {
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                    }
                    actualizarProgreso(i)
                } else {
                    break//return es otra opción
                }
            }
        }
    }

    suspend fun cargarDB() {
        withContext(Dispatchers.IO) {
            val db = myDatabase.writableDatabase
            db.use { // El use cierra automáticamente el puntero
                for (i in 1..500) {
                    if (isActive) {
                        db.execSQL("insert into usuario (id,nombre) values ($i,'persona$i') ")
                        actualizarProgreso(i)
                    } else {
                        break
                    }
                }
            }
        }
        //db.close()
    }
    //Con executor
//    fun doInBackground() {
//        myApplication.executor.execute {
//            control.compareAndSet(false, true)
//            for (i in 0..100 step 10) {
//                if (control.get()) {
//                    try {
//                        Thread.sleep(500)
//                    } catch (e: InterruptedException) {
//                        Thread.currentThread().interrupt()
//                    }
//                    actualizarProgreso(i)
//                } else {
//                    break//return es otra opción
//                }
//            }
//        }
//    }

//    fun stop() {
//        control.set(false)
//    }

    override fun actualizarProgreso(progreso: Int) {
        pbProgreso.progress = progreso
    }
}