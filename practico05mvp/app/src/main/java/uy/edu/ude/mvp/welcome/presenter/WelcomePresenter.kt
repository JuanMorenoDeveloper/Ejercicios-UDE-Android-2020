package uy.edu.ude.mvp.welcome.presenter

interface WelcomePresenter {
    fun goToLogin()
    fun showWelcome(username: String)
}