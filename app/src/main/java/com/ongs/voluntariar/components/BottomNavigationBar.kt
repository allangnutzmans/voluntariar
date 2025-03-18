package com.ongs.voluntariar.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ongs.voluntariar.ui.theme.Purple80
import com.ongs.voluntariar.ui.theme.PurpleGrey80

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = PurpleGrey80
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Explore",
                    tint = if (navController.currentBackStackEntryAsState().value?.destination?.route == "explore") Purple80 else Color.Gray
                )
            },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "explore",
            onClick = {
                navController.navigate("explore") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Bookmark,
                    contentDescription = "Saved",
                    tint = if (navController.currentBackStackEntryAsState().value?.destination?.route == "saved") Purple80 else Color.Gray
                )
            },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "saved",
            onClick = {
                navController.navigate("saved") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.People,
                    contentDescription = "Community",
                    tint = if (navController.currentBackStackEntryAsState().value?.destination?.route == "community") Purple80 else Color.Gray
                )
            },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "community",
            onClick = {
                navController.navigate("community") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "OrgInfo",
                    tint = if (navController.currentBackStackEntryAsState().value?.destination?.route == "orgInfo") Purple80 else Color.Gray
                )
            },
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
