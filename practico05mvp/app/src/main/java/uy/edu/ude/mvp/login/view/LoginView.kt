package uy.edu.ude.mvp.login.view

interface LoginView {
    fun goToWelcome(usuario: String)
    fun doLogin()
    fun showMessage(msgId: Int)
}