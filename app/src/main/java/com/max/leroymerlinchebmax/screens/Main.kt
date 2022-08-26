package com.max.testcompose.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.max.leroymerlinchebmax.CustomPutty
import com.max.leroymerlinchebmax.PuttyRepository
import com.max.leroymerlinchebmax.screens.ProductDetails

@Composable
fun MainsScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 0.dp, 0.dp, 60.dp)
    ) {
        Text(
            text = "Шпаклевки",
            fontSize = 20.sp,
            color=Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(24.dp, 16.dp, 16.dp)
                .size(360.dp, 56.dp)
        )
        Row(
            modifier = Modifier
                .horizontalScroll(ScrollState(0))
        ) {
            Image(
                painter = painterResource(id = com.max.leroymerlinchebmax.R.drawable.base_putty), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(155.dp, 72.dp)
                    .padding(12.dp, 8.dp)
            )
            Image(
                painter = painterResource(id = com.max.leroymerlinchebmax.R.drawable.finish_putty), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(158.dp, 72.dp)
                    .padding(8.dp, 8.dp)
            )
            Image(
                painter = painterResource(id = com.max.leroymerlinchebmax.R.drawable.super_finish_putty),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(185.dp, 72.dp)
                    .padding(8.dp, 8.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = com.max.leroymerlinchebmax.R.drawable.ic_baseline_swap_vert_24),
                contentDescription = null,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Цена по возрастанию",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(0.dp, 18.dp)
            )

            Image(
                painter = painterResource(id = com.max.leroymerlinchebmax.R.drawable.ic_baseline_tune_24),
                contentDescription = null,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Фильтры",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(0.dp, 18.dp)

            )

        }
        val puttyRepository = PuttyRepository()
        val getAllData = puttyRepository.getAllData()
        LazyColumn() {
            items(items = getAllData) {  putty ->
                CustomPutty(putty = putty)
            }
        }
        //LazyColumns()

    }

}



