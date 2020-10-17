package uy.edu.ude.zoomdemo.usescases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import uy.edu.ude.zoomdemo.entities.Usuario

class ClientZoomApi(
    private val usuario: Usuario,
    private val urlApi: String
) : ZoomApi {
    override suspend fun send(): JSONObject =
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(urlApi)
                .header("Authorization", Credentials.basic(usuario.username, usuario.password))
                .build()
            val response = client.newCall(request).execute()
            val body = response.body!!.string()
            response.close()
            return@withContext JSONObject(body)
        }

}