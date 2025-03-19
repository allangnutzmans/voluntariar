package com.ongs.voluntariar.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
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
        /*NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Map,
                    contentDescription = "Maps",
                    tint = if (navController.currentBackStackEntryAsState().value?.destination?.route == "maps") Purple80 else Color.Gray
                )
            },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "maps",
            onClick = {
                navController.navigate("maps") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )*/
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
                    Icons.Filled.Person,
                    contentDescription = "Perfil",
                    tint = if (navController.currentBackStackEntryAsState() .value?.destination?.route == "profile") Purple80 else Color.Gray
                )
            },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == "profile",
            onClick = { navController.navigate("profile") }
        )
    }
}
