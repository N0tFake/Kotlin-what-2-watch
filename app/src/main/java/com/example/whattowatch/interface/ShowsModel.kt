package com.example.whattowatch.`interface`

data class PageShows(
    val page: Int,
    val results: List<Shows>
)

data class Shows(
    val id: Int,
    val title: String?,
    val name: String?,
    val overview: String,
    val poster_path: String,
    val media_type: String,
    val release_date: String?,
    val first_air_date: String?,
    val vote_average: Float
)
