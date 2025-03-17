package com.ongs.voluntariar.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ongs.voluntariar.components.BottomNavigationBar
import com.ongs.voluntariar.screens.CommunityScreen
import com.ongs.voluntariar.screens.ExploreScreen
import com.ongs.voluntariar.screens.OrgInfoScreen
import com.ongs.voluntariar.screens.SavedScreen

@Composable
fun MainLayout(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "explore",
            modifier = Modifier.padding(innerPadding)
        ) {
            //composable(route = "signin") { SignInScreen(navController) }
            //composable(route = "home") { HomeScreen(navController) }
            composable(route = "explore") { ExploreScreen(navController) }
            composable(route = "orgInfo") { OrgInfoScreen(navController) }
            composable(route = "community") { CommunityScreen() }
            composable(route = "saved") { SavedScreen(navController) }
        }
    }
}
