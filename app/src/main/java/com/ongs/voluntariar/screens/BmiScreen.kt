package com.ongs.voluntariar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun BmiScreen(navController: NavController?) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier = Modifier
                .background(Color.Cyan)
            )
        {


        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BmiScreenPreview() {
    BmiScreen(null)
}