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

    fun getMovies(){
        viewModelScope.launch {
            try {
                val response = apiService.getAllMedia(1)
                if(response.results.isNotEmpty()){
                    val aux = mutableListOf<Movies>()
                    for(item in response.results){
                        if(item.media_type == "tv" || item.media_type == "movie"){
                            aux.add(item)
                        }
                    }
                    _movies.value = aux
                }
            } catch (e: Exception) {}
        }
    }
}