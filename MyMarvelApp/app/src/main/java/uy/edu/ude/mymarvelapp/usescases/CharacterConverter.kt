package uy.edu.ude.mymarvelapp.usescases

import org.json.JSONObject
import uy.edu.ude.mymarvelapp.entities.Character

class CharacterConverter {
    fun toEntity(jsonBody: String): Character {
        val json = JSONObject(jsonBody)
        val data = json.getJSONObject("data")
        val results = data.getJSONArray("results")
        //Se asume que viene un solo resultado
        //results.length()==1
        val result = results.getJSONObject(0)
        val id = result.getInt("id")
        val name = result.getString("name")
        val description = result.getString("description")
        val comics = result.getJSONObject("comics")
        val nrComics = comics.getInt("available")
        val thumbnail = result.getJSONObject("thumbnail")
        val path = thumbnail.getString("path")
        val extension = thumbnail.getString("extension")
        val thumbnailUrl = "$path/portrait_incredible.$extension".replace("http", "https")
        return Character(id, name, description, nrComics, thumbnailUrl)
    }
}