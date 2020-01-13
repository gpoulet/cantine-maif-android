package io.poulet.cantinemaif.retrofit

import okhttp3.ResponseBody
import retrofit2.http.GET

interface WebService {

    @GET("/Communication/Afficheur/index/61")
    suspend fun getMenu(): ResponseBody
}