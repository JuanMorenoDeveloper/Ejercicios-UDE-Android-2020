package uy.edu.ude.mvp.login.presenter

import uy.edu.ude.mvp.model.entity.Usuario

interface LoginPresenter {
    fun callLoginVerifier(usuario: Usuario)
    fun onDestroy()
}