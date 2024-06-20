package com.galassinitecnology.movieapp.utils

import com.galassinitecnology.movieapp.api.model.response.ErrorResponse
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException

object ResponseParser {

    fun parseError(response: Response<*>): String {
        val gson = Gson()
        val error: String = try {
            response.errorBody()?.string() ?: "Erro desconhecido"
        } catch (e: IOException) {
            return "Erro de leitura do response"
        }
        return gson.fromJson(error, ErrorResponse::class.java).error
    }

}