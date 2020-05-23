package uy.edu.ude.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val tvHello=findViewById<TextView>(R.id.tvHello)
        tvHello.text = "Test"
        btnOk.setOnClickListener {
            tvHello.text = "Test OK"
            val nombre = edNombre.text.toString()
            val bundle = Bundle()
            bundle.putString("nombre", nombre)
            val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
    }
}
