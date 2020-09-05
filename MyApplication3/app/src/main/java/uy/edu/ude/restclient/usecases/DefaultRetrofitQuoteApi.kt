package uy.edu.ude.restclient.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import uy.edu.ude.restclient.entities.Response

class DefaultRetrofitQuoteApi(private val urlServer: String) : QuoteApi {
    override suspend fun getQuoteRandom(): Response =
        withContext(Dispatchers.IO) {
            val retrofit = Retrofit.Builder().baseUrl(urlServer)
                .addConverterFactory(ResponseConverterFactory()).build()
            //val service = retrofit.create(QuoteApi::class.java)
            val service = retrofit.create(RetrofitQuoteApi::class.java)
            return@withContext service.getQuoteById(5)
        }
}