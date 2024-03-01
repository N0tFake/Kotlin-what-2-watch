package com.example.whattowatch.`interface`

data class PageMovies(
    val page: Int,
    val results: List<Movies>
)

data class Movies(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Float
)
