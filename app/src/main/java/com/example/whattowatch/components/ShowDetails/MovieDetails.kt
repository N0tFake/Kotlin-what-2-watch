package com.example.whattowatch.components.ShowDetails

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.whattowatch.components.ShowDetails.BodyShowDetails.BodyShowDetailsComponent
import com.example.whattowatch.components.ShowDetails.HeaderShowDetails.HeaderShowDetails
import com.example.whattowatch.`interface`.MovieDetails
import com.example.whattowatch.`interface`.ShowDetails
import com.example.whattowatch.`interface`.Shows
import com.example.whattowatch.view.ShowView

@Composable
fun MovieDetailsComponet(
    viewModel: ShowView,
    movie: MovieDetails
){


    val genres = movie.genres.size

    val show = movie.toShow()
    Column (modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Button(
            onClick = {
                viewModel.addShowToWatch(show)
            }
        ){
            Text("Teste")
        }
        HeaderShowDetails(
            title = movie.title,
            poster_path = movie.poster_path,
            backdrop_path = movie.backdrop_path,
            date = movie.release_date,
            genres = movie.genres,
            rating = movie.vote_average
        )
        BodyShowDetailsComponent(
            overview = movie.overview,
            tagline = movie.tagline,
            created_by = movie.created_by
        )
    }
}

fun MovieDetails.toShow(): Shows {
    return Shows(
        id = this.id,
        title = this.title,
        name = null, // 'MovieDetails' não tem um campo 'name'
        overview = this.overview,
        poster_path = this.poster_path,
        media_type = "movie", // Supondo que todos os 'MovieDetails' são filmes
        release_date = this.release_date,
        first_air_date = null, // 'MovieDetails' não tem um campo 'first_air_date'
        vote_average = this.vote_average
    )
}