package uy.edu.ude.mymarvelapp.usescases.api

import uy.edu.ude.mymarvelapp.entities.Character

interface MarvelApi {
    suspend fun getCharacterById(id: Int): Character
}