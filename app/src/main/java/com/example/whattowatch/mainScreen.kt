package com.example.whattowatch

import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.whattowatch.screens.HomeScreen
import com.example.whattowatch.screens.ShowDetailsScreen
import com.example.whattowatch.view.ShowView
import com.example.whattowatch.view.SearchViewModel

sealed class What2WatchScreen(val route: String) {
    object Home: What2WatchScreen("home")
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
        composable(What2WatchScreen.Home.route){
            HomeScreen(
                navController = navController,
                moviesViewModel = moviesViewModel,
                searchViewModel = searchViewModel
            )
        }
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

