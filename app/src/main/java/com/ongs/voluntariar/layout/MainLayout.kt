
package com.ongs.voluntariar.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.firebase.auth.FirebaseAuth
import com.ongs.voluntariar.components.BottomNavigationBar
import com.ongs.voluntariar.screens.CommunityScreen
import com.ongs.voluntariar.screens.ExploreScreen
import com.ongs.voluntariar.screens.OrgInfoScreen
import com.ongs.voluntariar.screens.ProfileScreen
import com.ongs.voluntariar.screens.RegisterScreen
import com.ongs.voluntariar.screens.SavedScreen
import com.ongs.voluntariar.screens.SignInScreen

@Composable
fun MainLayout(navController: NavHostController) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    val showBottomBar = currentUser != null

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (currentUser != null) "explore" else "signIn",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("signIn") { SignInScreen(navController) }
            composable("register") { RegisterScreen(navController) }
            composable("explore") { ExploreScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
            composable("saved") { SavedScreen(navController) }
            composable("community") { CommunityScreen(navController) }
            composable(
                "orgInfo/{name}/{location}/{about}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("location") { type = NavType.StringType },
                    navArgument("about") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                OrgInfoScreen(
                    name = backStackEntry.arguments?.getString("name") ?: "",
                    location = backStackEntry.arguments?.getString("location") ?: "",
                    about = backStackEntry.arguments?.getString("about") ?: "",
                    navController = navController
                )
            }
        }
    }
}