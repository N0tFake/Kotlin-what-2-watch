package com.example.whattowatch.components.BottomAppBar

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.whattowatch.What2WatchScreen

@Composable
fun BottomAppBarComponent(
    navController: NavController
){

    val items = listOf<ItemNavigateBar>(
        ItemNavigateBar("Home", Icons.Default.TaskAlt, What2WatchScreen.Home),
        ItemNavigateBar("Discovery", Icons.Default.Explore, What2WatchScreen.Discovery)
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

}

class ItemNavigateBar(
    val label: String,
    val icon: ImageVector,
    val screen: What2WatchScreen
)