package com.example.whattowatch

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.whattowatch.components.BottomAppBar.BottomAppBarComponent
import com.example.whattowatch.screens.HomeScreen
import com.example.whattowatch.screens.DiscoveryScreen
import com.example.whattowatch.screens.ShowDetailsScreen
import com.example.whattowatch.view.ShowView
import com.example.whattowatch.view.SearchViewModel

sealed class What2WatchScreen(val route: String) {
    object Home: What2WatchScreen("home")
    object Discovery: What2WatchScreen("discovery")
    object MovieDetails: What2WatchScreen("movie/{itemId}"){
        fun createRoute(itemId: Int) = "movie/$itemId"
    }

}

@Composable
fun What2WatchApp(
    moviesViewModel: ShowView,
    searchViewModel: SearchViewModel
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = What2WatchScreen.Home.route
    ) {
        // HOME
        composable(What2WatchScreen.Home.route){
            HomeScreen(
                navController = navController,
                moviesViewModel = moviesViewModel,
                searchViewModel = searchViewModel
            )
        }

        // DISCOVERY
        composable(What2WatchScreen.Discovery.route){
            DiscoveryScreen(
                navController = navController,
                moviesViewModel = moviesViewModel,
                searchViewModel = searchViewModel
            )
        }

        // SHOW DETAILS
        composable(
            What2WatchScreen.MovieDetails.route,
            arguments = listOf(navArgument("itemId") {
                type = NavType.StringType
            })
        ){
            val movieId = it.arguments?.getString("itemId")
            ShowDetailsScreen(
                navController = navController,
                viewModel = moviesViewModel,
                id = movieId ?: "No ID",
            )
        }
    }

}

