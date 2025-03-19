package com.ongs.voluntariar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ongs.voluntariar.R

@Composable
fun SavedScreen(navController: NavController?){
    val searchState = remember {
        mutableStateOf("")
    }

    val ongList = listOf(
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

    Column(modifier = Modifier.fillMaxSize()
        .padding(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        // Barra de pesquisa
        OutlinedTextField(
            value = searchState.value,
            onValueChange = { searchValue -> searchState.value = searchValue },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0), RoundedCornerShape(40.dp)),
            textStyle = TextStyle(color = Color.Black),
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Buscar") },
            placeholder = { Text(stringResource(R.string.find_ongs)) },
            shape = RoundedCornerShape(40.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Cards
        LazyColumn {
            items(ongList) { ong ->
                if (navController !== null){
                    OngSavedCard(ong, navController)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun OngSavedCard(ong: Ong, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color(0xFF4A1056)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6)) // Borda roxa
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Placeholder da imagem
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.LightGray, RoundedCornerShape(8.dp))
                ) {
                    Image(
                        painter = painterResource(id = ong.imageRes ?: R.drawable.img),
                        contentDescription = "Imagem da ONG",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp), // Sem padding aqui
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = ong.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = ong.location, fontSize = 14.sp, color = Color.Gray)
                }

                IconButton(onClick = { /* TODO: Adicionar lógica de favorito */ }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate("orgInfo/${ong.name}/${ong.location}/${ong.about}/${ong.imageRes}")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A1056)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 8.dp)
                ) {
                    Text(text = stringResource(R.string.visit), color = Color.White)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SavedScreenPreview(){
    SavedScreen(navController = null)
}
