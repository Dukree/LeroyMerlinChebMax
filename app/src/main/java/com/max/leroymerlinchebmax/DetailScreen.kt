package com.max.leroymerlinchebmax

sealed class DetailScreen(val route: String){
    object Detail: DetailScreen(route = "detail_screen")
}
