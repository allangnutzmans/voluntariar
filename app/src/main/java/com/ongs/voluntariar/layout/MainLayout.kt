
package com.ongs.voluntariar.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.ongs.voluntariar.components.BottomNavigationBar
import com.ongs.voluntariar.screens.*

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
            composable("community") { CommunityScreen() }
            composable("orgInfo") { OrgInfoScreen(navController) }
        }
    }
}