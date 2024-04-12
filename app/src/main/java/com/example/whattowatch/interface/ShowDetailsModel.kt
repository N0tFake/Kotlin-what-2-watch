package com.example.whattowatch.`interface`

data class MovieDetails(
    val id: Int,
    val backdrop_path: String,
    val genres: List<Genres>,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val vote_average: Float,
    val created_by: List<Created>
)

data class TvSeriesDetails(
    val id: Int,
    val name: String,
    val overview: String,
    val genres: List<Genres>,
    val poster_path: String,
    val backdrop_path: String,
    val created_by: List<Created>,
    val first_air_date: String,
    val Seasons: List<Seasons>,
    val status: String,
    val tagline: String,
    val vote_average: Float
)

data class Created(
    val name: String,
)

data class Seasons(
    val season_number: Int,
    val episode_count: Int,
    val name: String,
    val vote_average: Float,
    val air_date: String

)

data class Genres(
    val id: Int,
    val name: String
)


data class GetCreditsCrewModel(
    val crew: List<CrewDetailsModel>
)

data class CrewDetailsModel(
    val job: String,
    val department: String,
    val name: String
)

sealed class ShowDetails<out L, out R> {
    data class Movie<out L>(val a: L): ShowDetails<L, Nothing>()
    data class TvSerie<out R>(val b: R): ShowDetails<Nothing, R>()
}
