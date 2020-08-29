package uy.edu.ude.restclient.usecases

import android.util.Log
import org.json.JSONObject
import uy.edu.ude.restclient.entities.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnectionQuoteApi(private val urlServer: String) : QuoteApi {
    //En segundo plano
    override fun getQuoteRandom(): Response {
        val url = URL(urlServer)
        val result = StringBuilder("")
        try {
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.setRequestProperty(
                "Content-Type",
                "application/json; charset=UTF-8"
            )
            httpURLConnection.requestMethod = "GET"
            val input = BufferedReader(
                InputStreamReader(httpURLConnection.inputStream)
            )

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
            result.append("""
                {
                  "type": "error",
                  "value": {
                    "id": -1,
                    "quote": "Error en la petición"
                  }
                }
            """)
        }
        return strToResponse(result.toString())
        // `in`.close()//El use sustituye al close()
    }

    fun strToResponse(body: String): Response {
        val json = JSONObject(body)
        val value = json.getJSONObject("value")
        val id = value.getInt("id")
        val type = json.getString("type")
        val quote = value.getString("quote")
        return Response(id, type, quote)
    }
}