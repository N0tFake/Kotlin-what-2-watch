package com.example.whattowatch.components.ShowDetails.BodyShowDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whattowatch.`interface`.Created

@Composable
fun BodyShowDetailsComponent(
    overview: String,
    tagline: String,
    created_by: List<Created>
){
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = tagline,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        )

        Text("Sinopse", fontWeight = FontWeight.Bold)
        Text(text = overview)

        Row (
            modifier = Modifier.padding(top = 10.dp)
        ) {
            for (direction in created_by) {
                Column (
                    modifier = Modifier.padding(end = 20.dp)
                ) {
                    Text(direction.name, fontWeight = FontWeight.Bold)
                    Text("Diretor(a)")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBodyShowDetailsComponent(
    overview: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
    tagline: String = "Lorem ipsum dolor sit amet.",
    created_by: List<Created> = listOf(
        Created(name = "Diretor 1"),
        Created(name = "Diretor 2")
    )
) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = tagline,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        Text("Sinopse", fontWeight = FontWeight.Bold)
        Text(text = overview)

        Row (
            modifier = Modifier.padding(top = 10.dp)
        ) {
            for (direction in created_by) {
                Column (
                    modifier = Modifier.padding(end = 20.dp)
                ) {
                    Text(direction.name, fontWeight = FontWeight.Bold)
                    Text("Diretor(a)")
                }
            }
        }
    }
}

