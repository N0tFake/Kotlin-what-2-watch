package com.example.whattowatch.components.ShowDetails.HeaderShowDetails

import android.icu.text.SimpleDateFormat
import android.media.Rating
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.whattowatch.`interface`.Genres
import com.example.whattowatch.`interface`.Shows
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun HeaderShowDetails(
    title: String,
    backdrop_path: String,
    poster_path: String,
    genres: List<Genres>,
    rating: Float,
    date: String
){

    val year = getYear(date)
    val releaseDate = formatDate(date)
    val genresText = getGenres(genres)

    Box () {
        AsyncImage(
            model = "https://media.themoviedb.org/t/p/w500$backdrop_path",
            contentDescription = "plano de fundo do filme $title",
            modifier = Modifier.fillMaxWidth().drawWithContent {
                drawContent()
                drawRect(color = Color.Black.copy(alpha = 0.5f))
            }
        )
        Row (
            modifier = Modifier.padding(10.dp)
        ) {
            AsyncImage(
                model = "https://media.themoviedb.org/t/p/w500$poster_path",
                contentDescription = "Poster do filme$title",
                modifier = Modifier.width(125.dp)
            )
            Column (
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(text = "$title ($year)")
                Text(text = releaseDate)
                Text(text = genresText)
                BadgeRating(rating)
            }
        }
    }
}

fun getYear(date: String): String{
    val formatInput = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formatOutput = SimpleDateFormat("yyyy", Locale.getDefault())

    val aux = formatInput.parse(date)
    return formatOutput.format(aux)
}

fun formatDate(date: String): String{
    val formatInput = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formatOutput = SimpleDateFormat("dd 'de' MMM 'de' yyyy", Locale.getDefault())

    val aux = formatInput.parse(date)
    return formatOutput.format(aux!!)
}

fun getGenres(genres: List<Genres>): String{
    return genres.joinToString(", ") {it.name}
}

@Composable
fun BadgeRating(
    value: Float
){

    Row {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Star rating",
            tint = Color.Yellow,
            modifier = Modifier.size(16.dp)
        )

        Text(
            text = String.format("%.1f", value),

            )
    }

}