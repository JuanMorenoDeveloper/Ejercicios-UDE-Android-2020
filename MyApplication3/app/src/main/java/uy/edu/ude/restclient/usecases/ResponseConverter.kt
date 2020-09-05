package uy.edu.ude.restclient.usecases

import okhttp3.ResponseBody
import uy.edu.ude.restclient.entities.Response

class ResponseConverter : retrofit2.Converter<ResponseBody, Response> {
    override fun convert(value: ResponseBody): Response = Converter().strToResponse(value.string())
}
