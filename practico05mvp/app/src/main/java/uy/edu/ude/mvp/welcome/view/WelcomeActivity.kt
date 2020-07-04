package uy.edu.ude.mvp.welcome.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import uy.edu.ude.mvp.R
import uy.edu.ude.mvp.login.view.LoginActivity
import uy.edu.ude.mvp.model.usecases.UsernameModifier
import uy.edu.ude.mvp.welcome.presenter.DefaultWelcomePresenter
import uy.edu.ude.mvp.welcome.presenter.WelcomePresenter

class WelcomeActivity : AppCompatActivity(), WelcomeView {

    private lateinit var presenter: WelcomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        presenter = DefaultWelcomePresenter(this, UsernameModifier())
        presenter.showWelcome(this.intent.extras?.getString("nombre") ?: "")
        init()
    }

    private fun init() {
        btnBye.setOnClickListener {
            presenter.goToLogin()
        }
    }

    override fun showWelcome(username: String) {
        tvNombre.text = username
    }

    override fun goToLogin() {
        val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
