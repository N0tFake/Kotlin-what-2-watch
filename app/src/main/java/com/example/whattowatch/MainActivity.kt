package com.example.whattowatch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.example.whattowatch.screens.HomeScreen
import com.example.whattowatch.ui.theme.WhatToWatchTheme
import com.example.whattowatch.view.MovieView
import com.example.whattowatch.view.SearchViewModel

class MainActivity : ComponentActivity() {

    private val moviesViewModel: MovieView by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WhatToWatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Box{
                        HomeScreen(
                            moviesViewModel = moviesViewModel,
                            searchViewModel =  searchViewModel
                        )
                    }
                }
            }
        }
    }
}

