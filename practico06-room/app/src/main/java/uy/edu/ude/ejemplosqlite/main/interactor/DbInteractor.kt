package uy.edu.ude.ejemplosqlite.main.interactor

import uy.edu.ude.ejemplosqlite.entity.Usuario

interface DbInteractor {
    suspend fun save(usuario: Usuario): String
    suspend fun update(usuario: Usuario): String
    suspend fun findById(id: Int): String
    suspend fun findAll(): String
    suspend fun delete(usuario: Usuario): String
}