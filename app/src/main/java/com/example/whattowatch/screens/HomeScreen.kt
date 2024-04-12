package com.example.whattowatch.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whattowatch.components.AppBar.AppBar
import com.example.whattowatch.components.BottomAppBar.BottomAppBarComponent
import com.example.whattowatch.components.DiscoveryShowList.DiscoveryShowList
import com.example.whattowatch.components.ShowCard.ShowCard
import com.example.whattowatch.`interface`.SearchWidgetState
import com.example.whattowatch.view.ShowView
import com.example.whattowatch.view.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    moviesViewModel: ShowView,
    searchViewModel: SearchViewModel
){

    val searchWidgetState = searchViewModel.searchWidgetState.collectAsState()
    val searchTextState = searchViewModel.searchTextState.collectAsState("")

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val list = listOf("1", "2", "3", "4")

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AppBar(
                searchWidgetState = searchWidgetState.value,
                searchTextState = searchTextState.value,
                onTextChange = {
                  searchViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                  searchViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                  Log.d("Searched Text", it)
                },
                onSearchTriggered = {
                  searchViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                },
                scrollBehavior = scrollBehavior

            )
        },
        bottomBar = {
            BottomAppBarComponent(navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(16.dp)
        ){

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = innerPadding,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalItemSpacing = 16.dp
            ) {
                items(list) { i ->
                    Text("i")
                }
            }

        }
    }
}


