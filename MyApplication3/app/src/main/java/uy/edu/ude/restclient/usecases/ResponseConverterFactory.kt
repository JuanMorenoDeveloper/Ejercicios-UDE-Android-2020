package uy.edu.ude.restclient.usecases

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import uy.edu.ude.restclient.entities.Response
import java.lang.reflect.Type

//Retrofit usa esta clase para convertir la respuesta de la invocación al objeto de dominio
class ResponseConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, Response>? {
        return ResponseConverter()
    }
}
