package uy.edu.ude.restclient.usecases

import org.json.JSONObject
import uy.edu.ude.restclient.entities.Response

class Converter {
    fun strToResponse(body: String): Response {
        val json = JSONObject(body)
        val value = json.getJSONObject("value")
        val id = value.getInt("id")
        val type = json.getString("type")
        val quote = value.getString("quote")
        return Response(id, type, quote)
    }
}