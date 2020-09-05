package uy.edu.ude.restclient.main.interactor

import uy.edu.ude.restclient.main.presenter.Presenter
import uy.edu.ude.restclient.services.QuoteApiHttpUrl

class MainInteractor(private val url: String) : Interactor {

    override suspend fun doInBackground(presenter: Presenter, param: String) {
        val quote = QuoteApiHttpUrl(url)//QuoteApiOkHttp(url)//DefaultQuoteApiRetrofit(url)
        val response = quote.findQuoteById(param)
        presenter.updateView(response)
    }
}
