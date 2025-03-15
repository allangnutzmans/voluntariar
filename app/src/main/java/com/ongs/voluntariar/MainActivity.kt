package com.ongs.voluntariar

//Auth
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ongs.voluntariar.screens.BmiScreen
import com.ongs.voluntariar.screens.ExploreScreen
import com.ongs.voluntariar.screens.HomeScreen
import com.ongs.voluntariar.screens.OrgInfoScreen
import com.ongs.voluntariar.screens.SignInActivity
import com.ongs.voluntariar.ui.theme.VoluntariarTheme

class MainActivity : ComponentActivity() {
    //private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //auth = FirebaseAuth.getInstance()

        enableEdgeToEdge()
        setContent {
            VoluntariarTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "singin",
                ) {
                    composable(route = "singin") { SignInActivity(navController) }
                    composable(route = "home") { HomeScreen(navController) }
                    composable(route = "bmi") { BmiScreen(navController) }
                    composable(route = "orgInfo") { OrgInfoScreen(navController) }
                    composable(route = "explore") { ExploreScreen(navController) }
                }
            }
        }
    }
}