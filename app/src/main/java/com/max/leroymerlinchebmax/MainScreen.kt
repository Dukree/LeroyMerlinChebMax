package com.max.leroymerlinchebmax

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.background(Color.White),
        bottomBar = { BottomBar(navController = navController)}
    ) {
    BottomNavGraph(navController = navController)
        
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Main,
        BottomBarScreen.Cart
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination , navController = navController )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text =screen.title, color = Color.Green )
        },
        icon = {
            Icon(imageVector =screen.icon , contentDescription ="Navigation Icon" , Modifier.background(color = Color.Black) )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        }==true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}