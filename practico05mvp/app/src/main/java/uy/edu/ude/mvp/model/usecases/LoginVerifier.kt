package uy.edu.ude.mvp.model.usecases

import uy.edu.ude.mvp.model.entity.Usuario

class LoginVerifier {
    init {
        val users = HashMap<String, String>()
        users.put("cat", "black")
        users.put("dog", "brown")
        users.put("bird", "blue")
    }

    fun isValid(usuario: Usuario): Boolean {
        if (usuario.nombre == "user" && usuario.password == "pass")
            return true
        return false
    }
}