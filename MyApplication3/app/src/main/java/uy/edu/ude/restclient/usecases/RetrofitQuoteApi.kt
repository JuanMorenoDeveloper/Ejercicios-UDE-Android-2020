package uy.edu.ude.restclient.usecases

import retrofit2.http.GET
import retrofit2.http.Path
import uy.edu.ude.restclient.entities.Response

interface RetrofitQuoteApi {
    @GET("api/random")
    suspend fun getQuoteRandom(): Response

    @GET("api/{id}")
    suspend fun getQuoteById(@Path("id") id: Int): Response
}