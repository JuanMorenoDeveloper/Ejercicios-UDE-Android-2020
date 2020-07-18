package uy.edu.ude.mvp

import uy.edu.ude.mvp.login.view.LoginView

class LoginActivityFake:LoginView {
    override fun goToWelcome(usuario: String) {
        println(usuario)
    }

    override fun doLogin() {
        println("doLogin")
    }

    override fun showMessage(msgId: Int) {
        println("showMessage")
    }
}