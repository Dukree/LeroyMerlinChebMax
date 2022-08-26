package com.max.leroymerlinchebmax

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.max.testcompose.screens.Cart
import com.max.testcompose.screens.MainsScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Main.route
    ) {
        composable(route = BottomBarScreen.Main.route) {
            MainsScreen()
        }
        composable(route = BottomBarScreen.Cart.route) {
            Cart()

//            val putty = navController.previousBackStackEntry?.arguments?.getParcelable<Putty>("putty")
//            putty?.let {
//                AcceptData(putty = it, navController = navController)
//            }
        }
    }
}



