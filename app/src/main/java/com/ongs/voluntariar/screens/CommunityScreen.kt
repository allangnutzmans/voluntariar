package com.ongs.voluntariar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ongs.voluntariar.R
import com.ongs.voluntariar.components.CommunityCard

data class Ong(
    val name: String,
    val location: String,
    val post: String,
    val about: String,
    val imageRes: Int? = null
)

val ongs = listOf(
    Ong(
        name = "Instituto Esperança",
        location = "Av. das Nações, 123 - São Paulo, SP, 01000-000",
        post = "Promovendo a inclusão social e educação para crianças.",
        about = "O Instituto Esperança atua há mais de 10 anos oferecendo suporte educacional para crianças em situação de vulnerabilidade.",
        imageRes = R.drawable.ong1
    ),
    Ong(
        name = "Projeto Vida Nova",
        location = "Rua das Flores, 456 - Rio de Janeiro, RJ, 22000-000",
        post = "Oferecendo apoio psicológico para famílias carentes.",
        about = "Nosso objetivo é proporcionar assistência psicológica gratuita para famílias em situação de risco.",
        imageRes = R.drawable.ong
    ),
    Ong(
        name = "Abrace Mais",
        location = "Praça da Liberdade, 789 - Belo Horizonte, MG, 30100-000",
        post = "Combate à fome e distribuição de cestas básicas.",
        about = "Abrace Mais trabalha na arrecadação e distribuição de alimentos para comunidades carentes.",
        imageRes = R.drawable.img
    ),
    Ong(
        name = "Sementes do Futuro",
        location = "Rua do Sol, 321 - Salvador, BA, 40000-000",
        post = "Incentivando a educação e a cultura nas periferias.",
        about = "O projeto leva cultura e oportunidades para crianças e adolescentes através de atividades educacionais e recreativas.",
        imageRes = R.drawable.img
    )
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
