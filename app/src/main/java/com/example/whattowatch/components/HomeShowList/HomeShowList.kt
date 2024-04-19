package com.example.whattowatch.components.HomeShowList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whattowatch.components.ShowCard.ShowCard
import com.example.whattowatch.`interface`.Shows
import com.example.whattowatch.view.ShowView

@Composable
fun HomeShowList(
    viewModel: ShowView,
    shows: List<Shows>,
    innerPadding: PaddingValues,
    navController: NavController
){
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(shows) { show ->
            ShowCard(show, viewModel, navController)
        }
    }
}