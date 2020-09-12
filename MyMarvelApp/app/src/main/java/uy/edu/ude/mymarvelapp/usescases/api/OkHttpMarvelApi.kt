package uy.edu.ude.mymarvelapp.usescases.api

import com.google.common.hash.Hashing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import uy.edu.ude.mymarvelapp.entities.Character
import uy.edu.ude.mymarvelapp.usescases.CharacterConverter

class OkHttpMarvelApi(
    private val urlServer: String,
    private val apiKey: String, private val privateKey: String
) : MarvelApi {

    override suspend fun getCharacterById(id: Int): Character =
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val response: okhttp3.Response
            val timestamp = System.currentTimeMillis()
            val hash = getHash(timestamp, privateKey, apiKey)
            client.run {
                val urlServer = """
                $urlServer/$id?ts=$timestamp&apikey=$apiKey&hash=$hash
            """
                println(urlServer)
                val request = Request.Builder().url(urlServer)
                    .header("Content-Type", "application/json; charset=UTF-8").build()
                response = client.newCall(request).execute()
            }
            CharacterConverter().toEntity(response.body!!.string())
        }

    private fun getHash(
        timestamp: Long,
        privateKey: String,
        apiKey: String
    ): String {
        return Hashing.md5().hashString(
            timestamp.toString() + privateKey + apiKey,
            Charsets.UTF_8
        ).toString()
    }
}