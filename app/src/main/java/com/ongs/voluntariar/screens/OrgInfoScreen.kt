package com.ongs.voluntariar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ongs.voluntariar.R
import com.ongs.voluntariar.ui.theme.Purple80

@Composable
fun OrgInfoScreen(navController: NavController?){
    Box(
        modifier = Modifier
            .background(color = Color(0xffaaaaaa))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF5F5F5)),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Ong Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
            )
                Column (
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ){
                    Column (
                        Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ){
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column (
                                    modifier = Modifier
                                        .padding(top = 5.dp)
                                ){
                                    Text(
                                        text = "Ong Ser e Crescer",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Rua Barão de Campinas - Campinas-SP,\n 13101-180",
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(0.dp, 5.dp, 0.dp, 0.dp)
                                    )
                                }

                                Row {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "Favorito"
                                        )
                                    }
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.Share,
                                            contentDescription = "Compartilhar"
                                        )
                                    }
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Sobre",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate \n",
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                            )
                        }
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ){
                        Button(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Purple80
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(text = "Doar")
                        }
                        OutlinedButton(modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                            border = BorderStroke(2.dp, Purple80),
                            onClick = {}) {
                            Text(text = "Entrar em contato", color = Purple80)
                        }
                    }
            }
            /*Button(onClick = {}) {
                Text(
                    text = "Clique aqui",
                    fontSize = 32.sp
                )
            }*/
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OrgInfoScreenPreview(){
    OrgInfoScreen(null)
}