package com.example.whattowatch.components.MovieDetails

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.whattowatch.components.HeaderShowDetails.HeaderShowDetails
import com.example.whattowatch.`interface`.MovieDetails
import com.example.whattowatch.`interface`.ShowDetails

@Composable
fun MovieDetailsComponet(
    movie: MovieDetails
){


    val genres = movie.genres.size

    Column (modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        HeaderShowDetails(
            title = movie.title,
            poster_path = movie.poster_path,
            backdrop_path = movie.backdrop_path,
            date = movie.release_date,
            genres = movie.genres
        )
    }
}