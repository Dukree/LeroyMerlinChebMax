package com.max.leroymerlinchebmax

import android.telecom.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.autoSaver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.max.leroymerlinchebmax.cart.CartViewModelFactory
import com.max.leroymerlinchebmax.catalog.CusPuttyViewModelFactory
import com.max.leroymerlinchebmax.screens.ProductDetails

import com.max.testcompose.screens.Cart
import com.max.testcompose.screens.MainsScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Main.route
    ) {
        composable(route = BottomBarScreen.Main.route) {

            MainsScreen(viewModel = viewModel(factory = CusPuttyViewModelFactory()),navController)

        }
        composable(route = BottomBarScreen.Cart.route) {

            Cart(viewModel = viewModel(factory = CartViewModelFactory()),
                onBackPress = {navController.popBackStack()}
            )
        }
        composable(route = DetailScreen.Detail.route){
            ProductDetails(onBackPress = {navController.popBackStack()}
            )
        }
    }
}



