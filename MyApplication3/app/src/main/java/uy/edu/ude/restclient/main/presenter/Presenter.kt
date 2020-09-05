package uy.edu.ude.restclient.main.presenter

import uy.edu.ude.restclient.entities.Response

interface Presenter {
    suspend fun sendGet()
    fun updateView(response: Response)
}