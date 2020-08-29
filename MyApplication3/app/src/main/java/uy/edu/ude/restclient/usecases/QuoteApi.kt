package uy.edu.ude.restclient.usecases

import uy.edu.ude.restclient.entities.Response

interface QuoteApi {
    fun getQuoteRandom(): Response
}