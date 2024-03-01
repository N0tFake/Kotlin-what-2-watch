package com.example.whattowatch.components.MoviesList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.whattowatch.components.MovieCard.MovieCard
import com.example.whattowatch.view.MovieView

@Composable
fun MoviesList(
    viewModel: MovieView,
    innerPadding: PaddingValues
){

    val movies by viewModel.movies.collectAsState()

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies) {
            movie -> MovieCard(movie)
        }
    }
    DisposableEffect(Unit){
        viewModel.getPosts()
        onDispose {  }
    }

}