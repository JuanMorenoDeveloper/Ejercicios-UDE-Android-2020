package uy.edu.ude.restclient.usecases

import retrofit2.http.GET
import retrofit2.http.Headers
import uy.edu.ude.restclient.entities.Response

interface QuoteApi {
    @Headers(
        "Content-Type",
        "application/json; charset=UTF-8"
    )
    @GET("api/random")
    suspend fun getQuoteRandom(): Response
}