package com.ongs.voluntariar.screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ongs.voluntariar.R

@Composable
fun HomeScreen(navController: NavController?){
    var yourNameState = remember {
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xffaaaaaa))
                    .padding(top = 100.dp, bottom = 2 .dp)

            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Card (
                modifier = Modifier
                    .fillMaxSize()
                    .height(500.dp),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                )
            ) {
                Column (
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                ){
                    Column {
                        Modifier.
                        fillMaxWidth()
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        TextField(
                            value = yourNameState.value,
                            onValueChange = {
                                yourNameState.value = it
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = {
                                Text(text = stringResource(R.string.your_name))
                            }

                        )
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Back")
                        }
                        Button(onClick = {
                            navController!!.navigate("bmi")
                        }) {
                            Text(text = stringResource(R.string.next),)
                        }
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
private fun HomeScreenPreview(){
    HomeScreen(null)
}