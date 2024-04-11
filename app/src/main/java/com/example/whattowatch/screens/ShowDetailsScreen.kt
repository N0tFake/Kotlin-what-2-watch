package com.example.whattowatch.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.whattowatch.components.MovieDetails.MovieDetailsComponet
import com.example.whattowatch.components.TvSerieDetails.TvSeriesDetailsComponet
import com.example.whattowatch.`interface`.MovieDetails
import com.example.whattowatch.`interface`.ShowDetails
import com.example.whattowatch.`interface`.TvSeriesDetails
import com.example.whattowatch.view.ShowView

@Composable
fun ShowDetailsScreen(
    navController: NavController,
    viewModel: ShowView,
    id: String
){

    val show by viewModel.showDetails.collectAsState(null)

    when(show){
        is ShowDetails.Movie -> {
            val movieDetails = (show as ShowDetails.Movie<MovieDetails?>).a
            if (movieDetails != null) {
                MovieDetailsComponet(movie = movieDetails)
            }
        }
        is ShowDetails.TvSerie -> {
            val serieDetails = (show as ShowDetails.TvSerie<TvSeriesDetails?>).b
            if (serieDetails != null){
                TvSeriesDetailsComponet(serie = serieDetails)
            }
        }

        else -> null
    }

}


