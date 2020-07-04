package uy.edu.ude.mvp.login.presenter

import uy.edu.ude.mvp.R
import uy.edu.ude.mvp.login.view.LoginView
import uy.edu.ude.mvp.model.entity.Usuario
import uy.edu.ude.mvp.model.usecases.LoginVerifier

class DefaultLoginPresenter(
    var view: LoginView?,
    val verifier: LoginVerifier
) : LoginPresenter {

    override fun callLoginVerifier(usuario: Usuario) {
        if (verifier.isValid(usuario)) {
            view?.goToWelcome(usuario.nombre)
        } else {
            view?.showMessage(R.string.user_invalid)
        }
    }

    override fun onDestroy() {
        view = null
    }
}