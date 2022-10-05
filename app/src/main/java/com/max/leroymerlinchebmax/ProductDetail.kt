package com.max.leroymerlinchebmax.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.max.leroymerlinchebmax.*
import com.max.leroymerlinchebmax.R
import com.max.leroymerlinchebmax.ui.theme.LeroyMerlinChebMaxTheme
import com.max.leroymerlinchebmax.ui.theme.backgroundColor
import com.max.leroymerlinchebmax.ui.theme.backgroundColors
import com.max.testcompose.screens.Cart
import com.max.testcompose.screens.MainsScreen


@Composable
fun ProductDetails(onBackPress: () -> Unit = {}) {
          Column(modifier = Modifier.size(360.dp,640.dp)) {
              Row(
                  modifier = Modifier
                      .size(360.dp, 56.dp)
                      .padding(20.dp, 0.dp, 20.dp, 0.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
              ) {
                IconButton(onClick = { onBackPress}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "ArrowBack", tint = Color.Black  )
                }



                      //modifier = Modifier.padding(20.dp, 20.dp, 0.dp, 0.dp)

                  Image(
                      painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                      contentDescription = "More",
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
                      color = Color.Black,
                      fontSize = 16.sp
                  )
                  Image(
                      painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                      contentDescription = "Bookmark",



                  )
              }
              Row(modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp, 22.dp, 0.dp, 20.dp)) {
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
                  Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
              }
              Divider()
              Row(modifier = Modifier
                  .size(360.dp, 80.dp)
                  .padding(16.dp, 0.dp, 16.dp, 0.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                   ) {

                  Text(
                      text = "65 ₽/шт.",
                      textAlign = TextAlign.Start,
                      //modifier = Modifier.padding(16.dp, 0.dp, 0.dp,0.dp),
                      fontWeight = FontWeight.Bold,
                      fontSize = 18.sp,
                      color = Color.Black
                  )
                  Spacer(modifier = Modifier.width(100.dp))
                  Buttons()
              }

          }

      }

  //}

@Composable
fun Buttons (){
    Button(
        modifier = Modifier
            .size(125.dp, 48.dp)
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
            ,
        colors = ButtonDefaults.buttonColors(colors.backgroundColors),
        onClick = {

        }) {
        Text(text = "В корзину", fontSize = 16.sp,
        color = Color.White)
    }
}
@Preview(showBackground = true)
@Composable
fun ProductDetailPreview() {

        ProductDetails()

}



