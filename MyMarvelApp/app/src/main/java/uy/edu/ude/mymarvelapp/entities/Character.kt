package uy.edu.ude.mymarvelapp.entities

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val nrComics: Int,
    val thumbnailUrl: String
)