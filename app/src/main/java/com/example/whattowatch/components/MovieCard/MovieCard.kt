package com.example.whattowatch.components.MovieCard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.whattowatch.`interface`.Movies

@Composable
fun MovieCard(
    movie: Movies
){

    val title: String? = movie.title ?: movie.name
    val releaseDate: String = movie.release_date ?: ""



    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth().height(150.dp)
        // size(width = 240.dp, height = 100.dp)
    ) {
        Row{
            AsyncImage(
                model = "https://media.themoviedb.org/t/p/w440_and_h660_face" + movie.poster_path,
                contentDescription = "poster do filme $title"
            )
            Column {
                Text(text = "$title", color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = releaseDate, color = Color.White)
                Text(text = "${movie.vote_average}", color = Color.White)
            }
        }
    }
}