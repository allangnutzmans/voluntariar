package com.ongs.voluntariar.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Explore, contentDescription = "Explore") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "explore",
            onClick = {
                navController.navigate("explore") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Bookmark, contentDescription = "Saved") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "saved",
            onClick = {
                navController.navigate("saved") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.People, contentDescription = "Community") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "community",
            onClick = {
                navController.navigate("community") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Info, contentDescription = "OrgInfo") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "orgInfo",
            onClick = {
                navController.navigate("orgInfo") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )

    }
}
