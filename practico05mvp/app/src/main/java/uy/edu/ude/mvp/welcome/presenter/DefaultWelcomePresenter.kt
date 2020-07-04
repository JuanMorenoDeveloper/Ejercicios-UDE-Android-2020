package uy.edu.ude.mvp.welcome.presenter

import uy.edu.ude.mvp.model.usecases.UsernameModifier
import uy.edu.ude.mvp.welcome.view.WelcomeView

class DefaultWelcomePresenter(
    private val view: WelcomeView,
    private val modifier: UsernameModifier
) : WelcomePresenter {
    override fun goToLogin() {
        view.goToLogin()
    }

    override fun showWelcome(username: String) {
        view.showWelcome(modifier.toUpperCase(username))
    }
}