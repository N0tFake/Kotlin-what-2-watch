package com.example.whattowatch.components.ShowDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.whattowatch.components.ShowDetails.BodyShowDetails.BodyShowDetailsComponent
import com.example.whattowatch.components.ShowDetails.HeaderShowDetails.HeaderShowDetails
import com.example.whattowatch.`interface`.MovieDetails
import com.example.whattowatch.`interface`.ShowDetails
import com.example.whattowatch.`interface`.Shows
import com.example.whattowatch.`interface`.TvSeriesDetails
import com.example.whattowatch.view.ShowView

@Composable
fun TvSeriesDetailsComponet(
    serie: TvSeriesDetails,
    viewModel: ShowView,
    navController: NavController,
){

    val show = serie.toShow()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderShowDetails(
            title = serie.name,
            poster_path = serie.poster_path,
            backdrop_path = serie.backdrop_path,
            date = serie.first_air_date,
            genres = serie.genres,
            rating = serie.vote_average,
            navController = navController
        )
        BodyShowDetailsComponent(
            overview = serie.overview,
            tagline = serie.tagline,
            created_by = serie.created_by
        )
        Button(
            onClick = {
                viewModel.addShowToWatch(show)
            }
        ){
            Text("Teste")
        }
    }

}


fun TvSeriesDetails.toShow(): Shows {
    return Shows(
        id = this.id,
        title = null,
        name = this.name, // 'MovieDetails' não tem um campo 'name'
        overview = this.overview,
        poster_path = this.poster_path,
        media_type = "serie", // Supondo que todos os 'MovieDetails' são filmes
        release_date = null,
        first_air_date = this.first_air_date, // 'MovieDetails' não tem um campo 'first_air_date'
        vote_average = this.vote_average
    )
}