package com.example.whattowatch.service

import com.example.whattowatch.`interface`.Movies
import com.example.whattowatch.`interface`.PageMovies
import com.example.whattowatch.`interface`.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Accept: application/json",
        "Authorization: Bearer "
    )
    @GET("movie/popular?language=pt-BR")
    suspend fun getPosts(@Query("page") page: Int): PageMovies

}