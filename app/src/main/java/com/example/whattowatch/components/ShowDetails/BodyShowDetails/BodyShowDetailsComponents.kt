package com.example.whattowatch.components.ShowDetails.BodyShowDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.whattowatch.`interface`.Created

@Composable
fun BodyShowDetailsComponent(
    overview: String,
    tagline: String,
    created_by: List<Created>
){
    Column {
        Text(text = tagline)
        Text(text = overview)
        Row {
            for (direction in created_by){
                Column {
                    Text(direction.name)
                    Text("Criação")
                }
            }
        }
    }
}


