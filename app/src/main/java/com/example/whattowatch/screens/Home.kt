package com.example.whattowatch.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.whattowatch.components.AppBar.AppBar
import com.example.whattowatch.components.MoviesList.MoviesList
import com.example.whattowatch.`interface`.SearchWidgetState
import com.example.whattowatch.view.MovieView
import com.example.whattowatch.view.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    moviesViewModel: MovieView,
    searchViewModel: SearchViewModel
){

    val searchWidgetState = searchViewModel.searchWidgetState.collectAsState()
    val searchTextState = searchViewModel.searchTextState.collectAsState("")

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

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
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(8.dp)
        ){

            MoviesList(
                viewModel = moviesViewModel,
                innerPadding = innerPadding
            )
        }
    }
}


