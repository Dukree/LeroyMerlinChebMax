package com.max.leroymerlinchebmax.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.max.leroymerlinchebmax.*
import com.max.leroymerlinchebmax.R
import com.max.leroymerlinchebmax.ui.theme.backgroundColor
import com.max.testcompose.screens.Cart
import com.max.testcompose.screens.MainsScreen


@Composable
fun ProductDetails() {
//  Scaffold(modifier = Modifier.size(360.dp,640.dp), bottomBar = {
//      BottomAppBar(Modifier.size(360.dp,56.dp)) {
//              IconButton(onClick = { nav }) {
//                  Column() {
//                      Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.Black, modifier = Modifier.width(176.dp)
//                      )
//                      Text(textAlign = TextAlign.Center, text = "Корзина", color = Color.Black, modifier = Modifier.width(176.dp), fontSize = 10.sp )
//                  }
//
//              }
//
//
//        IconButton(onClick = ) {
//                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "ShoppingCart", tint = Color.Black, modifier = Modifier.width(176.dp))
//
//
//        }
//      }
//  }) {
          Column(modifier = Modifier.fillMaxSize()) {
              Row(
                  modifier = Modifier
                      .size(360.dp, 56.dp)
                      .padding(20.dp, 0.dp, 20.dp, 0.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
              ) {
                  Image(
                      painter = painterResource(id = R.drawable.ic_baseline_west_24),
                      contentDescription = "Back",
                      //modifier = Modifier.padding(20.dp, 20.dp, 0.dp, 0.dp)
                  )
                  Image(
                      painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                      contentDescription = "More",
                      //modifier = Modifier
                     //     .fillMaxWidth()
                     //     .padding(0.dp, 20.dp, 32.dp, 0.dp),

                  )
              }
              Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center)
              {
                  Image(
                      painter = painterResource(id = R.drawable.green_belt),
                      contentDescription = "GreenBelt",
                      modifier = Modifier.size(229.dp, 229.dp),
                  )
              }
              Text(text = "ЛМ 82733340", modifier = Modifier.padding(16.dp, 62.dp, 10.dp,8.dp), color = Color.Black)
              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp, 10.dp, 16.dp, 21.dp),
                  horizontalArrangement = Arrangement.SpaceBetween
              ) {
                  Text(
                      text = "Стимулятор роста для семян и рассады Green Belt",
                      modifier = Modifier
                          .size(280.dp, 44.dp),
                      fontWeight = FontWeight.Bold,
                      color = Color.Black
                  )
                  Image(
                      painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                      contentDescription = "Bookmark",



                  )
              }
              Row(modifier = Modifier
                  .fillMaxWidth()
                  .fillMaxWidth()
                  .padding(16.dp, 22.dp, 0.dp, 20.dp)) {
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
              }
//              Row(modifier = Modifier
//                  .size(360.dp, 48.dp)
//                  .padding(8.dp, 6.dp, 0.dp, 9.dp)) {
//                  Image(
//                      painter = painterResource(id = R.drawable.reviews),
//                      contentDescription = "Reviews",
//                      modifier = Modifier
//                          .size(181.dp, 48.dp)
//
//                  )
//              }


              Row(modifier = Modifier
                  .height(80.dp)
                  .width(360.dp)
                  .padding(16.dp, 0.dp, 16.dp, 0.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                   ) {

                  Text(
                      text = "65 Р/шт.",
                      textAlign = TextAlign.Start,
                      //modifier = Modifier.padding(16.dp, 0.dp, 0.dp,0.dp),
                      fontWeight = FontWeight.Bold,
                      fontSize = 18.sp,
                      color = Color.Black
                  )
                  //Spacer(modifier = Modifier.size(100.dp ))
                  Buttons()

              }
              MainScreen()
          }

      }

  //}

@Composable
fun Buttons (){
    Button(
        modifier = Modifier
            .size(125.dp, 48.dp)
            //.padding(0.dp,0.dp,16.dp,0.dp)
            ,


        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.backgroundColor,
            contentColor = Color.White
        ),
        onClick = {

        }) {
        Text(text = "В корзину", fontSize = 16.sp)
    }
}




