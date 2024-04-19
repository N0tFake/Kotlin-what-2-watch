package com.example.whattowatch.screens

import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whattowatch.components.ShowDetails.MovieDetailsComponet
import com.example.whattowatch.components.ShowDetails.TvSeriesDetailsComponet
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

    val isLoading by viewModel.loading.collectAsState()
    val show by viewModel.showDetails.collectAsState(null)

    if(isLoading && show == null){
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }else{
        when(show){
            is ShowDetails.Movie -> {
                val movieDetails = (show as ShowDetails.Movie<MovieDetails?>).a
                if (movieDetails != null) {
                    MovieDetailsComponet(viewModel, movieDetails)
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


}


