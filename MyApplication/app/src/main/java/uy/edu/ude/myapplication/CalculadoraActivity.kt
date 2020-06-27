package uy.edu.ude.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadora.*

class CalculadoraActivity() :
    AppCompatActivity() {

    private var n1: Int = 0;
    private var n2: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        init()
    }

    fun init() {
        btnMas.setOnClickListener {
            leerNumeros()
            tvResultado.text = sumar().toString()
        }
        btnMenos.setOnClickListener {
            leerNumeros()
        }
    }

    private fun leerNumeros() {
        n1 = edN1.text.toString().toInt()
        n2 = edN2.text.toString().toInt()
    }

    fun sumar(): Int {
        return n1 + n2
    }

    fun restar() = n1 - n2

}