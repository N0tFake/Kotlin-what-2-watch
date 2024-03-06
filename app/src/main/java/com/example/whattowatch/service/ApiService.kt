package com.example.whattowatch.service

import com.example.whattowatch.BuildConfig
import com.example.whattowatch.`interface`.PageMovies
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.Properties

const val AUTHORIZATION = "Authorization: Bearer ${BuildConfig.TOKEN_API}"

interface ApiService {

    @Headers(
        "Accept: application/json",
        AUTHORIZATION
    )
    @GET("trending/all/day?language=pt-BR")
    suspend fun getAllMedia(@Query("page") page: Int): PageMovies

}