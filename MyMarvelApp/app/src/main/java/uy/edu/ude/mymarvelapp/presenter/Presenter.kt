package uy.edu.ude.mymarvelapp.presenter

import uy.edu.ude.mymarvelapp.entities.Character

interface Presenter {
    suspend fun sendRequest(id: Int)
    fun updateView(character: Character)
}