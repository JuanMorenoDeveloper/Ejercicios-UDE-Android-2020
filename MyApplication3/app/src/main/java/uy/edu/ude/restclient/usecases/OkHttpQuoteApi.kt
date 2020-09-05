package uy.edu.ude.restclient.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import uy.edu.ude.restclient.entities.Response

class OkHttpQuoteApi(private val urlServer: String) : QuoteApi {
    override suspend fun getQuoteRandom(): Response =
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val response: okhttp3.Response
            client.run {
                val request = Request.Builder().url(urlServer)
                    .header("Content-Type", "application/json; charset=UTF-8").build()
                response = client.newCall(request).execute()
            }
            return@withContext Converter().strToResponse(response.body!!.string())
        }
}