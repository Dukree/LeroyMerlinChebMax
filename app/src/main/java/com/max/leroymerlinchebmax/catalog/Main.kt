package com.max.testcompose.screens


import android.telecom.Call
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigator
import androidx.navigation.compose.ComposeNavigator
import com.max.leroymerlinchebmax.*
import com.max.leroymerlinchebmax.R
import com.max.leroymerlinchebmax.cart.models.CartItem
import com.max.leroymerlinchebmax.catalog.CustomPuttyViewModel
import com.max.leroymerlinchebmax.catalog.models.CusPutty
import com.max.leroymerlinchebmax.catalog.models.Putty
import com.max.leroymerlinchebmax.screens.ProductDetails
import com.max.leroymerlinchebmax.ui.theme.*

@Composable
fun MainsScreen(viewModel: CustomPuttyViewModel,
navController:NavController) {
    val catalogState by viewModel.cusPuttyState.collectAsState()
    val cartState by viewModel.cartState.collectAsState()

    Column(
        modifier = Modifier
            .size(360.dp, 780.dp)
            .padding(0.dp, 0.dp, 0.dp, 50.dp)
    ) {
        Text(
            text = "Шпаклевки",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(24.dp, 16.dp, 16.dp)
                .size(360.dp, 56.dp)
        )
        Row(
            modifier = Modifier
                .size(360.dp, 88.dp)
                .horizontalScroll(ScrollState(0))
        ) {
            Image(
                painter = painterResource(id = R.drawable.base_putty),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(155.dp, 72.dp)
                    .padding(16.dp, 8.dp, 8.dp, 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.finish_putty),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(158.dp, 72.dp)
                    .padding(8.dp, 8.dp, 8.dp, 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.super_finish_putty),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(185.dp, 72.dp)
                    .padding(8.dp, 8.dp, 8.dp, 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
            Row(modifier = Modifier.size(360.dp, 56.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_swap_vert_24),
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp)
                )
                Text(
                    text = "Цена по возрастанию",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(0.dp, 18.dp, 18.dp, 18.dp)
                        .size(149.dp, 20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_tune_24),
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp)
                )
                Text(
                    text = "Фильтры",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(8.dp, 18.dp, 18.dp, 18.dp)
                        .size(62.dp, 20.dp)
                )
            }

                when (catalogState) {
                    is Result.Success<CusPutty> -> {

                        LazyColumn(modifier = Modifier
                            .fillMaxSize()) {
                            val catalog = (catalogState as Result.Success<CusPutty>).data
                            items(catalog.count) { index ->
                                CusPuttyListItem(putty = catalog.getByPosition(index),
                                    cartState = cartState,
                                    onAddPress = { putty ->
                                        viewModel.addCartItem(putty)
                                    },navController)
                            }
                        }
                    }
                }

            }
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

@Composable
private fun CusPuttyListItem(
    putty: Putty,
    cartState: Result<CartItem> = Result.Loading,
    onAddPress: (putty: Putty) -> Unit = {},
    navController: NavController
) {
    Row(modifier = Modifier
        .clickable { navController.navigate(DetailScreen.Detail.route)}
        .fillMaxWidth()) {

        PuttyImage(putty = putty)
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text( text = putty.title, color = Color.Black)
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Stars",
                    modifier = Modifier.size(12.dp,12.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Stars",
                    modifier = Modifier.size(12.dp, 12.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Stars",
                    modifier = Modifier.size(12.dp, 12.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Stars",
                    modifier = Modifier.size(12.dp, 12.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Stars",
                    modifier = Modifier.size(12.dp, 12.dp)
                )
            }

               Text (
                    text = "${putty.price} ₽/шт.",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
                )
                Text(text = "77 ₽/шт.",
                    color = MaterialTheme.colors.Text77Psht,
                    fontSize = 12.sp)

            when (cartState) {
                is Result.Success<CartItem> -> {
                    val cart = cartState.data

                    AddButtonToCart(
                        putty = putty,
                        inCart = cart.putty.contains(putty),
                        onAddPress = { putty -> onAddPress(putty) },
                    )
                }
                is Result.Error -> {
                    Icon(
                        Icons.Filled.Warning, contentDescription = "Warning",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                is Result.Loading -> {
                    Icon(
                        Icons.Filled.Refresh, contentDescription = "Loading",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            }
            Divider(thickness = 1.dp, color = MaterialTheme.colors.Poloska)
        }

    }

}

@Composable
  fun AddButtonToCart(
    putty: Putty,
    inCart: Boolean = false,
    onAddPress: (putty: Putty) -> Unit = {}
) {

    val counterState = rememberSaveable{ mutableStateOf(1)}

    if (inCart ) {
        Button(onClick = { counterState.value++;onAddPress(putty)}, colors = ButtonDefaults.buttonColors(MaterialTheme.colors.backgroundColor))  {
            Text("${counterState.value} шт.", color = Color.Black)}
    } else {
        Button(onClick = { onAddPress(putty) }, colors = ButtonDefaults.buttonColors(MaterialTheme.colors.backgroundColor)) {
            Text(text = "В корзину", color = Color.Black)}

    }

}















