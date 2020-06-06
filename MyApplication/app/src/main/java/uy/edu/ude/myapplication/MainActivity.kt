package uy.edu.ude.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        //val tvHello=findViewById<TextView>(R.id.tvHello)
        tvHello.text = "Test"
        btnOk.setOnClickListener {
            tvHello.text = "Test OK"
            val nombre = edNombre.text.toString()
            val password = edPassword.text.toString()
            Toast.makeText(
                this,
                "Mi usuario es $nombre y mi clave es $password",
                Toast.LENGTH_LONG
            ).show()
            if (isValid(nombre, password)) {
                goToWelcome(nombre)
            } else {
                tvHello.text = "Usuario inválido"
                edPassword.error = "Contraseña inválida"
                Toast.makeText(
                    this,
                    "Usuario inválido",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun isValid(nombre: String, password: String): Boolean {
        if (nombre == "user" && password == "pass")
            return true
        return false
    }

//    private fun isValid(nombre: String, password: String) =
//        (nombre == "user" && password == "pass")


    private fun goToWelcome(nombre: String) {
        val bundle = Bundle()
        bundle.putString("nombre", nombre)
        val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }
}
