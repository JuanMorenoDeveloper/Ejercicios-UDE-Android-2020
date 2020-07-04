package uy.edu.ude.mvp.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uy.edu.ude.mvp.R
import uy.edu.ude.mvp.welcome.view.WelcomeActivity
import uy.edu.ude.mvp.login.presenter.DefaultLoginPresenter
import uy.edu.ude.mvp.login.presenter.LoginPresenter
import uy.edu.ude.mvp.model.entity.Usuario
import uy.edu.ude.mvp.model.usecases.LoginVerifier

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = DefaultLoginPresenter(this, LoginVerifier())
        init()
    }

    private fun init() {
        btnOk.setOnClickListener {
            doLogin()
        }
    }

    override fun doLogin() {
        val usuario = Usuario(edNombre.text.toString(), edPassword.text.toString())
        presenter.callLoginVerifier(usuario)
    }

    override fun showMessage(msgId: Int) {
        val mensaje = getString(msgId)
        tvHello.text = mensaje
        //edPassword.error = "Contraseña inválida" /
        Toast.makeText(
            this,
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }


    override fun goToWelcome(nombre: String) {
        val bundle = Bundle()
        bundle.putString("nombre", nombre)
        val intent = Intent(this@LoginActivity, WelcomeActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
