package uy.edu.ude.mymarvelapp.view

import uy.edu.ude.mymarvelapp.entities.Character

interface MainView {
    fun sendRequest(id: Int)
    fun showCharacter(character: Character)
}