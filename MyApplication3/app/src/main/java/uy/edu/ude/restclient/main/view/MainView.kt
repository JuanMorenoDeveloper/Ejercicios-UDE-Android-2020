package uy.edu.ude.restclient.main.view

import uy.edu.ude.restclient.entities.Response

interface MainView {
    fun doRequest()
    fun showResponse(response: Response)
}