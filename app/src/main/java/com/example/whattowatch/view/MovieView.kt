package com.example.whattowatch.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattowatch.`interface`.Movies
import com.example.whattowatch.`interface`.Post
import com.example.whattowatch.service.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieView: ViewModel() {
    private val apiService = RetrofitClient.api

    private val _movies = MutableStateFlow<List<Movies>>(emptyList())
    val movies = _movies.asStateFlow()

    fun getPosts(){
        viewModelScope.launch {
            try {
                val response = apiService.getPosts(1)
                if(response.results.isNotEmpty()){
                    _movies.value = response.results
                }
            } catch (e: Exception) {}
        }
    }
}