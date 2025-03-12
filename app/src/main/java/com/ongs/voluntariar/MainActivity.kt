package com.ongs.voluntariar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ongs.voluntariar.screens.BmiScreen
import com.ongs.voluntariar.screens.HomeScreen
import com.ongs.voluntariar.ui.theme.VoluntariarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            VoluntariarTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home",
                ) {
                    composable(route = "home") { HomeScreen(navController) }
                    composable(route = "bmi") { BmiScreen() }
                }
            }
        }
    }
}