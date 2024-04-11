package com.example.whattowatch.components.ShowCard

import androidx.compose.material3.Icon
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.whattowatch.What2WatchScreen
import com.example.whattowatch.`interface`.Shows
import com.example.whattowatch.view.ShowView
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowCard(
    movie: Shows,
    viewModel: ShowView,
    navController: NavController
){

    val title: String? = movie.title ?: movie.name
    val releaseDate = formatDate(movie)


    ElevatedCard(
        onClick = {
            if(movie.media_type == "movie"){
                viewModel.getMovieDetails(id = movie.id)
            }else{
                viewModel.getTvSeriesDetails(id = movie.id)
            }
            navController.navigate(What2WatchScreen.MovieDetails.createRoute(movie.id))
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ){

        Column{

            AsyncImage(
                model = "https://media.themoviedb.org/t/p/w500" + movie.poster_path,
                contentDescription = "Poster do filme $title",
            )


            Column (
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BadgeRating(movie.vote_average)
                    BadgeMediaType(movie.media_type)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "$title",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = releaseDate,
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }


        }
    }
}


fun formatDate(movie: Shows): String{

    val date = movie.release_date ?: movie.first_air_date

    val formatInput = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formatOutput = SimpleDateFormat("dd 'de' MMM 'de' yyyy", Locale.getDefault())

    val aux = formatInput.parse(date)
    return formatOutput.format(aux!!)
}

@Composable
fun BadgeMediaType(
    value: String
){

    var type: String = when(value){
        "movie" -> "Filme"
        "tv" -> "Serie/TV"
        else -> ""
    }

    if(type != ""){
        Text(
            text=type,
            color = MaterialTheme.colorScheme.inverseOnSurface,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.primary, RoundedCornerShape(4.dp)).padding(start = 5.dp, end = 5.dp)
        )
    }

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