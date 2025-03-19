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
import com.ongs.voluntariar.R
import androidx.navigation.NavController
import com.ongs.voluntariar.components.CommunityCard

data class Ong(
    val name: String,
    val location: String,
    val post: String,
    val about: String,
    val imageRes: Int? = null
)
val ongs = listOf(
    Ong("Ong Ser e Crescer", "Rua Barão de Campinas - Campinas-SP, 13101-180", "Lorem ipsum dolor sit amet...","Lorem ipsum dolor sit am nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", imageRes = R.drawable.ong ),
    Ong("Ong Ajudar Sempre", "Pellentesque habitant morbi...", "Vivamus sagittis lacus vel augue...", "Lorem ipsum dololacus vel augue laoreet rutrum faucibus.", imageRes = R.drawable.ong1),
    Ong("Ong Sorriso", "Curabitur blandit tempus...", "Integer posuere erat a ante...", "Lorem ipsum dolor sit amet...", imageRes = null),
    Ong("Ong Mundo Melhor", "Vestibulum id ligula porta...", "Curabitur blandit tempus porttitor...", "Lorem ipsum dolor sit amet...", imageRes = null)
)


@Composable
fun CommunityScreen(navController: NavController?){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffaaaaaa))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(ongs) { ong ->
                Box(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                ){
                    if (navController != null) {
                        CommunityCard(
                            name = ong.name,
                            description = ong.post,
                            location = ong.location,
                            about = ong.about,
                            imageRes = ong.imageRes  ?: R.drawable.ong,
                            navController = navController
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
    CommunityScreen(null)
}
