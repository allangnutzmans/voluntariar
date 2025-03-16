package com.ongs.voluntariar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ongs.voluntariar.R

@Composable
fun SavedScreen(navController: NavController?){
    val searchState = remember {
        mutableStateOf("")
    }

    val ongList = listOf(
        Ong("Ong Ser e Crescer", "Campinas - SP"),
        Ong("Ong Esperança Viva", "São Paulo - SP"),
        Ong("Ong Amigos do Bem", "Rio de Janeiro - RJ"),
        Ong("Ong Coração Solidário", "Belo Horizonte - MG")
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
                OngSavedCard(ong)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun OngSavedCard(ong: Ong) {
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
                )

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
                    onClick = { /* TODO: Adicionar navegação */ },
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
