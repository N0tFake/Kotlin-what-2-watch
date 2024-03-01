package com.example.whattowatch.view

import androidx.lifecycle.ViewModel
import com.example.whattowatch.`interface`.SearchWidgetState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel: ViewModel() {
    private val _searchWidgetState = MutableStateFlow<SearchWidgetState>(SearchWidgetState.CLOSED)
    val searchWidgetState = _searchWidgetState.asStateFlow()

    private val _searchTextState = MutableStateFlow<String>("")
    val searchTextState = _searchTextState.asSharedFlow()

    fun updateSearchWidgetState(newValue: SearchWidgetState){
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String){
        _searchTextState.value = newValue
    }
}