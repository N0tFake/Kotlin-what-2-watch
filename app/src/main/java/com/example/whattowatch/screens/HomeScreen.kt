package com.example.whattowatch.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whattowatch.components.AppBar.AppBar
import com.example.whattowatch.components.BottomAppBar.BottomAppBarComponent
import com.example.whattowatch.components.HomeShowList.HomeShowList
import com.example.whattowatch.`interface`.SearchWidgetState
import com.example.whattowatch.view.SearchViewModel
import com.example.whattowatch.view.ShowView

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

    val shows by moviesViewModel.showsToWatch.collectAsState()

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

            HomeShowList(
                viewModel = moviesViewModel,
                shows = shows,
                innerPadding = innerPadding,
                navController = navController
            )

        }
    }
}


