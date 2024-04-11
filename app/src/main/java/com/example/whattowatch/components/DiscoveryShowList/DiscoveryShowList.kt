package com.example.whattowatch.components.DiscoveryShowList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whattowatch.components.ShowCard.ShowCard
import com.example.whattowatch.view.ShowView

@Composable
fun DiscoveryShowList(
    viewModel: ShowView,
    innerPadding: PaddingValues,
    navController: NavController
){

    val movies by viewModel.movies.collectAsState()


    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(movies) { movie ->
            ShowCard(movie, viewModel, navController)
        }
    }

    DisposableEffect(Unit){
        viewModel.getMovies()
        onDispose {  }
    }

}