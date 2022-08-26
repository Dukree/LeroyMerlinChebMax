package com.max.testcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.max.leroymerlinchebmax.CustomPutty
import com.max.leroymerlinchebmax.Putty
import com.max.leroymerlinchebmax.PuttyRepository
import com.max.leroymerlinchebmax.R
import com.max.leroymerlinchebmax.screens.ProductDetails

@Composable
fun Cart() {
    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                contentDescription = "Icon More",
                alignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp, 0.dp, 0.dp)
            )
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp)) {
                Text(text = "Корзина",
                    fontSize = 34.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold)
            }
            val puttyRepository = PuttyRepository()
            val getAllData = puttyRepository.getAllData()
            LazyColumn() {
                items(items = getAllData) {  putty ->
                    CustomPutty(putty = putty)
                }
            }
            //LazyColumns()
           // AcceptData(putty = Putty(articleId = I , image = Int, title = String()), navController = NavController(context = Context) )

        }

    }
}

//@Composable
//fun LazyColumns(){
//
//}

//fun AcceptData(putty: Putty, navController: NavController) {

//    var putty = navController.previousBackStackEntry?.arguments?.getParcelable<Putty>("putty")
//    putty?.let {
//        AcceptData(putty = it, navController = navController)


//    navController.currentBackStackEntry?.arguments?.putParcelable("putty", putty)
//    navController.navigate("putty_details")
//}
