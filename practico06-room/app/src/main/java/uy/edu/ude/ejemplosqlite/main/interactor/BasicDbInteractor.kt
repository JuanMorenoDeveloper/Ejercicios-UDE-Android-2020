package uy.edu.ude.ejemplosqlite.main.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.repository.UsuarioDao

class BasicDbInteractor(private val usuarioRepository: UsuarioDao) : DbInteractor {
    override suspend fun save(usuario: Usuario): String {
        val usuarioFound = withContext(Dispatchers.IO) {
            usuarioRepository.findById(usuario.id)
        }
        return if (usuarioFound == null) {
            withContext(Dispatchers.IO) {
                usuarioRepository.save(usuario)
            }
            "Insert OK"
        } else {
            "Usuario ya existe"
        }
    }

    override suspend fun update(usuario: Usuario): String {
        withContext(Dispatchers.IO) {
            usuarioRepository.update(usuario)
        }
        return "Update OK"
    }

    override suspend fun findById(id: Int): String {
        val usuario = withContext(Dispatchers.IO) {
            usuarioRepository.findById(id)
        }
        return usuario?.toString() ?: "Usuario no encontrado"
    }

    override suspend fun findAll(): String {
        val usuarios = withContext(Dispatchers.IO) {
            usuarioRepository.findAll()
        }
        if (usuarios.isEmpty()) {
            return "Consulta sin resultados"
        }
        return usuarios.joinToString("") { "$it \n" }
    }

    override suspend fun delete(usuario: Usuario): String {
        withContext(Dispatchers.IO) {
            usuarioRepository.delete(usuario)
        }
        return "Delete OK"
    }
}