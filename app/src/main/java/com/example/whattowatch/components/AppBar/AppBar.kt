package com.example.whattowatch.components.AppBar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.whattowatch.`interface`.SearchWidgetState
import com.example.whattowatch.view.SearchViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
){

    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered,
                scrollBehavior = scrollBehavior
            )
        }
        SearchWidgetState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked,
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    onSearchClicked: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
){

    MediumTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text("title", maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Pesquisar")
            }
        },
        scrollBehavior = scrollBehavior
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
){

    Surface (
        modifier = Modifier.fillMaxWidth().height(56.dp),
        color = MaterialTheme.colorScheme.primary
    ) {

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { newValue: String ->
                onTextChange(newValue)
            },
            placeholder = {
                Text("Search movie", color = Color.White)
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            ),
            singleLine = true,

            leadingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()){
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = Color.White
                    )
                }
            },

            trailingIcon = {
                IconButton(
                    onClick = { onSearchClicked(text) }
                ){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                }
            },

            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = Color.White
            )
        )
    }

}
