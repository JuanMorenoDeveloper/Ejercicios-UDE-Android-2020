package uy.edu.ude.mvp.welcome.view

interface WelcomeView {
    fun showWelcome(username: String)
    fun goToLogin()
}