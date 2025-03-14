package com.ongs.voluntariar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun OrgInfoScreen(navController: NavController?){
    val yourNameState = remember {
        mutableStateOf("")
    }

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
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ){
                        Column {
                            Modifier
                                .fillMaxWidth()
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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "About",
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
                            onClick = { /*TODO*/ }
                        ) {
                            Text(text = "Donate")
                        }
                        OutlinedButton(modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                            border = BorderStroke(2.dp, ButtonDefaults.outlinedButtonColors().contentColor),
                            onClick = {
                            navController!!.navigate("bmi")
                        }) {
                            Text(text = "Contact")
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