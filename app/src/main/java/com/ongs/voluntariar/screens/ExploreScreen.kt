package com.ongs.voluntariar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ExploreScreen(navController: NavController?){
    var searchState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        // Barra de pesquisa
        OutlinedTextField(
            value = searchState.value,
            onValueChange = { searchValue -> searchState.value = searchValue },
            modifier = Modifier.fillMaxWidth().background(Color(0xFFE0E0E0), RoundedCornerShape(40.dp)),
            textStyle = TextStyle(color = Color.Black),
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Buscar") },
            placeholder = { Text("Encontrar ONGs") },
            shape = RoundedCornerShape(40.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Filtros
        val filters = listOf("Por perto", "Animais", "Idosos", "Educação", "Saúde")

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(filters) { _, filter ->
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF450B47)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .border(BorderStroke(1.dp, Color(0xFF450B47)), RoundedCornerShape(8.dp))
                ) {
                    Text(
                        text = filter,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        // Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(
                                Color.LightGray,
                                shape = RoundedCornerShape(16.dp)
                            ) // Simulando imagem
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "nome",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "cidade",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ExploreScreenPreview(){
    ExploreScreen(navController = null)
}