package com.ongs.voluntariar

//Auth
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.ongs.voluntariar.layout.MainLayout
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
                MainLayout(navController = navController)
            }
        }
    }
}
