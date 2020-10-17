package uy.edu.ude.zoomdemo.usescases

import org.json.JSONObject

interface ZoomApi {
    suspend fun send(): JSONObject
}