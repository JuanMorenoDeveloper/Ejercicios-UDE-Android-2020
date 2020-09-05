package uy.edu.ude.restclient.main.presenter

import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.main.view.MainView
import uy.edu.ude.restclient.usecases.QuoteApi

class MainPresenter(private val view: MainView, private val api: QuoteApi) : Presenter {
    override suspend fun sendGet() {
        updateView(api.getQuoteRandom())
    }

    override fun updateView(response: Response) {
        view.showResponse(response)
    }
}