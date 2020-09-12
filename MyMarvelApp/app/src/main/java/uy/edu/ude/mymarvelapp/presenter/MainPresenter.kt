package uy.edu.ude.mymarvelapp.presenter

import uy.edu.ude.mymarvelapp.entities.Character
import uy.edu.ude.mymarvelapp.usescases.api.MarvelApi
import uy.edu.ude.mymarvelapp.view.MainView

class MainPresenter(private val view: MainView, private val api: MarvelApi) : Presenter {
    override suspend fun sendRequest(id: Int) {
        updateView(api.getCharacterById(id))
    }

    override fun updateView(character: Character) {
        view.showCharacter(character)
    }

}