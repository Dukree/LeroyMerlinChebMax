package com.max.leroymerlinchebmax

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.max.leroymerlinchebmax.screens.ProductDetails


@Composable
fun CustomPutty(putty: Putty) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }

    )
    {
        PuttyImage(putty = putty)
    Column(modifier = Modifier
        .fillMaxWidth()) {

        Text(text = putty.title, color = Color.Black  )
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
        }

        Text(text = putty.price, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp,16.dp,0.dp,0.dp))
    }


    }
    val counterState = remember { mutableStateOf(0) }
    Button(
        onClick = {
            counterState.value++
        }, modifier = Modifier.padding(110.dp, 0.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray
        )
    ) {
        if (counterState.value == 0) {
            Text(text = "В корзину", fontSize = 14.sp)

        } else
            Text("${counterState.value}")
    }
    //ButtonAddToCart()

}

@Composable
private fun PuttyImage(putty: Putty) {
    Image(
        painter = painterResource(id = putty.image), contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(92.dp, 92.dp)
    )
}
//@Composable
//fun ButtonAddToCart(){
//
//    val counterState = remember { mutableStateOf(0) }
//    Button(
//        onClick = {
//            counterState.value++
//        }, modifier = Modifier.padding(110.dp, 0.dp), colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.LightGray
//        )
//    ) {
//        if (counterState.value == 0) {
//            Text(text = "В корзину", fontSize = 14.sp)
//
//        } else
//            Text("${counterState.value}")
//    }
//}
