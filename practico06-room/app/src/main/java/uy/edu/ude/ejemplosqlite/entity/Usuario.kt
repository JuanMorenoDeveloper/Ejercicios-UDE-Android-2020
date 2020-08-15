package uy.edu.ude.ejemplosqlite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String
) {
    companion object {
        val DEFAULT = Usuario(0, "")
    }
}