package com.max.leroymerlinchebmax.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.max.leroymerlinchebmax.Putty
import com.max.leroymerlinchebmax.R
import com.max.leroymerlinchebmax.ui.theme.backgroundColor


@Composable
fun ProductDetails() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(0.dp, 56.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_west_24),
                contentDescription = "Back",
                modifier = Modifier.padding(20.dp, 20.dp, 0.dp, 0.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                contentDescription = "More",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 32.dp, 0.dp),
                alignment = Alignment.BottomEnd
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),Arrangement.Center)
        {
            Image(
                painter = painterResource(id = R.drawable.green_belt),
                contentDescription = "GreenBelt",
                modifier = Modifier.size(229.dp, 229.dp),
            )
        }
        Text(text = "ЛМ 82733340", modifier = Modifier.padding(16.dp, 62.dp, 0.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(ScrollState(0))
        ) {
            Text(
                text = "Стимулятор роста для семян и рассады Green Belt", modifier = Modifier
                    .padding(16.dp, 10.dp, 64.dp)
                    .size(280.dp, 44.dp), fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                contentDescription = "Bookmark",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 8.dp),
                alignment = Alignment.Center
            )
        }
        Image(
            painter = painterResource(id = R.drawable.reviews),
            contentDescription = "Reviews",
            modifier = Modifier
                .size(181.dp, 48.dp)
                .padding(8.dp),
            alignment = Alignment.TopStart
        )
        Row(modifier = Modifier.fillMaxSize()) {
            
            Text(text = "65 Р/шт.", textAlign = TextAlign.Start, modifier = Modifier.padding(16.dp,10.dp,0.dp),      fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.size(150.dp,0.dp))
            Buttons()
        }


    }

}
@Composable
fun Buttons (){
    Button(
        modifier = Modifier
            .size(200.dp, 48.dp)
            .padding(0.dp, 0.dp, 16.dp),

        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.backgroundColor,
            contentColor = Color.White
        ),
        onClick = {

        }) {
        Text(text = "В корзину", fontSize = 16.sp)
    }
}



