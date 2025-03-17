package com.ongs.voluntariar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ongs.voluntariar.components.CommunityCard

data class Ong(
    val name: String,
    val location: String
)

val ongs = listOf(
    Ong("Ong Ser e Crescer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    Ong("Ong Ajudar Sempre", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus sagittis lacus vel augue laoreet rutrum faucibus."),
    Ong("Ong Sorriso", "Curabitur blandit tempus porttitor. Integer posuere erat a ante venenatis dapibus posuere velit aliquet."),
    Ong("Ong Mundo Melhor", "Vestibulum id ligula porta felis euismod semper. Curabitur blandit tempus porttitor.")
)

@Composable
fun CommunityScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffaaaaaa))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End

            ) {
                Text(text = "Filtrar")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(ongs) { ong ->
                    Box(
                        modifier = Modifier
                            .padding(bottom = 12.dp)
                    ){
                        CommunityCard(
                            title = ong.name,
                            description = ong.location,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CommunityScreenPreview() {
    CommunityScreen()
}
