package com.example.whattowatch.`interface`

data class PageTvShows(
    val page: Int,
    val results: List<Movies>
)

data class TvShows(
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,
    val media_type: String,
    val release_date: String,
    val vote_average: Float
)
