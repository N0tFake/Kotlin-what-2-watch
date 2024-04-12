package com.example.whattowatch.service

import com.example.whattowatch.BuildConfig
import com.example.whattowatch.`interface`.*
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Properties

const val AUTHORIZATION = "Authorization: Bearer ${BuildConfig.TOKEN_API}"

interface ApiService {

    @Headers(
        "Accept: application/json",
        AUTHORIZATION
    )
    @GET("trending/all/day?language=pt-BR")
    suspend fun getAllMedia(@Query("page") page: Int): PageShows

    @Headers(
        "Accept: application/json",
        AUTHORIZATION
    )
    @GET("movie/{id}?language=pt-BR")
    suspend fun getMovieDetails(@Path("id") id: Int): MovieDetails

    @Headers(
        "Accept: application/json",
        AUTHORIZATION
    )
    @GET("tv/{id}?language=pt-BR")
    suspend fun getTvSeriesDetails(@Path("id") id: Int): TvSeriesDetails


    @Headers(
        "Accept: application/json",
        AUTHORIZATION
    )
    @GET("movie/{id}/credits?language=pt-BR'")
    suspend fun getCrewDetails(@Path("id") id: Int): GetCreditsCrewModel

}