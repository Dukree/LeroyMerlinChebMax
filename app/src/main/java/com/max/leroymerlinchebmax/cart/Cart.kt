package com.max.testcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.max.leroymerlinchebmax.BottomBar
import com.max.leroymerlinchebmax.Result
import com.max.leroymerlinchebmax.cart.CartViewModel
import com.max.leroymerlinchebmax.cart.CartViewModelFactory
import com.max.leroymerlinchebmax.cart.models.CartItem
import com.max.leroymerlinchebmax.catalog.models.Putty
import com.max.leroymerlinchebmax.ui.theme.*


@Composable
fun Cart(viewModel: CartViewModel,
         onBackPress: () -> Unit = {}
) {
    val state by viewModel.state.collectAsState()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
    ) {
        Column(
            modifier = Modifier
                .size(360.dp, 650.dp)
                .padding(PaddingValues(0.dp, 0.dp, 0.dp, it.calculateBottomPadding()))
        ) {
            when (state) {
                is Result.Success<CartItem> -> {
                    CartBody(
                        modifier = Modifier.padding(0.dp),
                        cartItem = (state as Result.Success<CartItem>).data,
                        onBackPress = onBackPress
                    )
                }
                is Result.Error -> {
                    Text("Something went wrong!")
                }
                is Result.Loading -> {
                    Text("Loading...")
                }
            }

        }

    }
}

@Composable
private fun CartBody(
    cartItem: CartItem,
    modifier: Modifier,
    onBackPress: () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        if (0 == cartItem.count) {
            Text(
                modifier = Modifier
                    .padding(16.dp, 80.dp, 16.dp, 12.dp),
                text = "В корзине ничего нет",
                color = Color.Black,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .padding(16.dp, 126.dp, 16.dp, 0.dp),
                text = "Войдите в профиль, если вы уже добавляли товары под своими именем",
                color = Color.Black,
                fontSize = 16.sp
            )
            Button(
                modifier = Modifier
                    .padding(16.dp, 194.dp, 16.dp, 300.dp)
                    .size(328.dp, 48.dp),
                onClick = { /*TODO*/ },
                colors =ButtonDefaults.buttonColors(colors.backgroundColor)
            ) {
                Text(
                    text = "Войти",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.Black,
                    modifier = Modifier
                        .padding(0.dp,16.dp,16.dp,16.dp))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 0.dp, 16.dp)
                ) {
                    Text(
                        text = "Корзина",
                        fontSize = 34.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                    Divider(thickness = 1.dp, color = colors.Poloska,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp))
                Column()

                 {
                    CartList(
                    modifier.weight(1f),
                        cartItem = cartItem
                    )
                    TotalCount(cartItem = cartItem)

                }

            }
        }
    }
}
@Composable
private fun CartList(
    modifier: Modifier,
    cartItem: CartItem,

) {
    LazyColumn(modifier.fillMaxSize(1f)) {

        items(cartItem.count) { index ->

            CartListItem(cartItem.getByPostition(index))
        }

    }
}
@Composable
private fun CartListItem(
    putty: Putty,
    cartState: Result<CartItem> = Result.Loading,
    onAddPress: (putty: Putty) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
       )
    {
        Image(painter = painterResource(id = putty.image), contentDescription = "Image",contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(87.dp, 87.dp)
                .padding(8.dp, 0.dp, 8.dp, 0.dp))
        Column() {
            Text(text = putty.title,
                color = Color.Black)
                   AddButtonToCart(putty = putty)
            Divider(thickness = 1.dp, color = colors.Poloska,
                modifier = Modifier.padding(0.dp,16.dp,0.dp,16.dp))
        }

    }
}

@Composable
private fun AddButtonToCart(
    putty: Putty,
    onAddPress: (putty: Putty) -> Unit = {}
) {
    val counterState = rememberSaveable { mutableStateOf(1) }
    Button(
        onClick = { counterState.value++; },
        colors = ButtonDefaults.buttonColors(colors.backgroundColor)
    ) {
        Text("${counterState.value} шт.", color = Color.Black)
    }
}
@Composable
private fun TotalCount(
    cartItem: CartItem
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(116.dp)
       ) {

        Text(
            text = "Итого без доставки",
            color = MaterialTheme.colors.Text77Psht,
            modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Row( Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${cartItem.count} товаров весом 6,5 кг",
                color = Color.Black,
                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 7.dp)
            )

            Text(
                text = "${cartItem.totalPrice} ₽",
                color = Color.Black,
                modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 7.dp),
                fontWeight = FontWeight.Bold
            )

        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 6.dp)
                , onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = colors.backgroundColors)
        ) {
            Text(text = "Оформить заказ", fontSize = 16.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeroyMerlinChebMaxTheme {

        Cart(viewModel = viewModel())


    }
}





