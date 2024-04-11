package com.example.whattowatch.components.TvSerieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.example.whattowatch.components.HeaderShowDetails.HeaderShowDetails
import com.example.whattowatch.`interface`.TvSeriesDetails

@Composable
fun TvSeriesDetailsComponet(
    serie: TvSeriesDetails
){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderShowDetails(
            title = serie.name,
            poster_path = serie.poster_path,
            backdrop_path = serie.backdrop_path,
            date = serie.first_air_date,
            genres = serie.genres
        )
    }

}