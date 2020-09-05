package uy.edu.ude.restclient.usecases

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uy.edu.ude.restclient.entities.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnectionQuoteApi(private val urlServer: String) : QuoteApi {
    //En segundo plano
    override suspend fun getQuoteRandom(): Response =
        withContext(Dispatchers.IO) {
            //1. Defino la URL para comunicarme
            val url = URL(urlServer)
            val result = StringBuilder("")
            try {
                //2. Abro la conexión
                val httpURLConnection = url.openConnection() as HttpURLConnection
                //3. Defino MIME Type para negociación
                httpURLConnection.setRequestProperty(
                    "Content-Type",
                    "application/json; charset=UTF-8"
                )
                //4. Defino el método o verbo HTTP
                httpURLConnection.requestMethod = "GET"
                val input = BufferedReader(
                    InputStreamReader(httpURLConnection.inputStream)
                )
                //5. Proceso la respuesta
                input.use { //try-with-resources
                    //StringBuilder->Non ThreadSafe
                    //StringBuffer->ThreadSafe
                    var inputLine = input.readLine()
                    while (null != (inputLine)) {
                        result.append(inputLine)
                        inputLine = input.readLine()
                    }
                }
            } catch (e: IOException) {
                Log.e("HttpUrlConnection", e.message, e)
                result.append(
                    """
                {
                  "type": "error",
                  "value": {
                    "id": -1,
                    "quote": "Error en la petición"
                  }
                }
            """
                )
            }
            //6. Convierto la respuesta a objeto
            return@withContext Converter().strToResponse(result.toString())
            // `in`.close()//El use sustituye al close()
        }
}