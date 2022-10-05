package com.max.leroymerlinchebmax

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.isUnspecified
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Main: BottomBarScreen(
        route = "main",
        title = "Главная",
        icon = Icons.Default.Search
    )
    object Cart: BottomBarScreen(
        route = "cart",
        title = "Корзина",
        icon = Icons.Default.ShoppingCart
    )

}

