package uy.edu.ude.ejemplosqlite.repository

import androidx.room.*
import uy.edu.ude.ejemplosqlite.entity.Usuario

@Dao
interface UsuarioDao {
    @Insert
    suspend fun save(usuario: Usuario)

    @Update
    suspend fun update(usuario: Usuario)

    @Query("SELECT * FROM Usuario WHERE id = :id")
    suspend fun findById(id: Int): Usuario?

    @Query("SELECT * FROM Usuario")
    suspend fun findAll(): List<Usuario>

    @Delete
    suspend fun delete(usuario: Usuario)
}