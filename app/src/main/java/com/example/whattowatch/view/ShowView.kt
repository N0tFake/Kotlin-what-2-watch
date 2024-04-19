package com.example.whattowatch.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattowatch.`interface`.*
import com.example.whattowatch.service.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ShowView: ViewModel() {
    private val apiService = RetrofitClient.api

    private val _loading = MutableStateFlow<Boolean>(true)
    val loading = _loading.asStateFlow()

    private val _movies = MutableStateFlow<List<Shows>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _showsSearched = MutableStateFlow<List<Shows>>(emptyList())
    val showsSearched = _showsSearched.asStateFlow()

    private val _showDetails = MutableStateFlow<MovieOrTvSerieDetails?>(ShowDetails.Movie(null))
    val showDetails = _showDetails.asStateFlow()

    private val _showsToWatch = MutableStateFlow<List<Shows>>(emptyList())
    val showsToWatch = _showsToWatch.asStateFlow()

    private val _showsViewed = MutableStateFlow<List<Shows>>(emptyList())
    val showsViewed = _showsViewed.asStateFlow()

    fun addShowToWatch(show: Shows){
        val updatedList = _showsToWatch.value + show
        _showsToWatch.value = updatedList
    }

    fun getMovies(){
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = apiService.getAllMedia(1)
                if(response.results.isNotEmpty()){
                    val aux = mutableListOf<Shows>()
                    for(item in response.results){
                        if(item.media_type == "tv" || item.media_type == "movie"){
                            aux.add(item)
                        }
                    }
                    _movies.value = aux
                }
                _loading.value = false
            } catch (e: Exception) {}
        }
    }

    fun updateValueWithSearchShows(searchShows: List<Shows>){
        _showsSearched.value = searchShows
//        return _showsSearched.value
    }

    fun getMovieDetails(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true

                val response = apiService.getMovieDetails(id = id)
                val responseCrew = apiService.getCrewDetails(id=id)

                val filterDirections = getCrewByJobAndDepartment(
                    job = "Director",
                    crew = responseCrew.crew,
                    department = "Directing"
                )

                val directionList = mutableListOf<Created>()

                for(director in filterDirections){
                    directionList.add(Created(name = director.name))
                }

                val updateResponse = response.copy(created_by = directionList)

                _showDetails.value = ShowDetails.Movie(updateResponse)

                _loading.value = false
            } catch (e: Exception) {}
        }
    }

    fun getTvSeriesDetails(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true

                val response = apiService.getTvSeriesDetails(id = id)
                _showDetails.value = ShowDetails.TvSerie(response)

                _loading.value = false
            } catch (e: Exception) {}
        }
    }

    private fun getCrewByJobAndDepartment(crew: List<CrewDetailsModel>, job: String, department: String): List<CrewDetailsModel>{
        return crew.filter { it.job == job && it.department == department }
    }

}
