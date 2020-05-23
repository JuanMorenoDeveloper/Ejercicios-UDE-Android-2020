package uy.edu.ude.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val nombre = this.intent.extras?.getString("nombre") ?: ""
        tvNombre.text = nombre
        btnBye.setOnClickListener {
            Log.d("WelcomeActivity","El nombre que llego fue $nombre")
            Toast.makeText(this@WelcomeActivity, "Adios $nombre", Toast.LENGTH_LONG).show()
        }
    }
}
