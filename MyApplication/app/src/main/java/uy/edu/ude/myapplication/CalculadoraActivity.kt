package uy.edu.ude.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadora.*

class CalculadoraActivity() :
    AppCompatActivity() {

    constructor(n1: Int, n2: Int) : this() {
        CalculadoraActivity@ this.n1 = n1
        this.n2 = n2
    }

    private var n1: Int = 0
    private var n2: Int = 0

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
            //TODO Implementar resta
        }
        btnDividir.setOnClickListener {
            leerNumeros()
            tvResultado.text = tryDivide()
            //R.string.n2_eq_zero_error
        }
    }

    private fun leerNumeros() {
        n1 = edN1.text.toString().toInt()
        n2 = edN2.text.toString().toInt()
    }

    fun sumar(): Int {
        return n1 + n2
    }

    fun tryDivide(): String {
        return if (n2 == 0) {
            "El número 2 no puede ser 0"
        } else {
            dividir().toString()
        }
//        var result=""
//        if (n2 == 0) {
//            result="El número 2 no puede ser 0"
//        } else {
//            result=dividir().toString()
//        }
//        return result
    }

    fun dividir(): Double {
        return n1 / n2.toDouble()
    }

    fun restar() = n1 - n2

}