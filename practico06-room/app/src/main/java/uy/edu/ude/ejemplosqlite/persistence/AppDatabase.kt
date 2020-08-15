package uy.edu.ude.ejemplosqlite.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.repository.UsuarioDao

@Database(entities = arrayOf(Usuario::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}