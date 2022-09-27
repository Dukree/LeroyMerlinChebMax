//package com.max.leroymerlinchebmax
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.max.leroymerlinchebmax.screens.ProductDetails
//import com.max.testcompose.screens.Cart
//
//
//@Composable
//fun CustomPutty(putty: Putty,
//    viewModel: CustomPuttyViewModel,
//    onCartClick: () -> Unit = {},
//) {
//    val catalogState by viewModel.cusPuttyState.collectAsState()
//    val cartState by viewModel.cartState.collectAsState()
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    {
//        PuttyImage(putty = putty)
//    Column(modifier = Modifier
//        .fillMaxWidth()) {
//
//        Text(text = putty.title, color = Color.Black  )
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
//            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
//            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
//            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
//            Image(painter = painterResource(id = R.drawable.vector), contentDescription = "Stars", modifier = Modifier.size(12.dp,12.dp) )
//        }
//
//        Text(text = putty.price, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp,16.dp,0.dp,0.dp))
//    }
//        when (catalogState) {
//            is Result.Success<CusPutty> -> {
//                Box{
//                    LazyColumn(modifier = Modifier.fillMaxSize()){
//                        val catalog = (catalogState as Result.Success<CusPutty>).data
//                        items(catalog.count) {index ->
//                            CusPuttyListItem(putty = catalog.getByPosition(index),
//                                             cartState = cartState,
//                                            onAddPress = {putty ->
//                                                viewModel.addCartItem(putty)
//                                            })
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//    val counterState = remember { mutableStateOf(0) }
//    val mainViewModel: MainViewModel = viewModel()
//    //val product = mainViewModel.addtocart(cartItem = CartItem(putty))
//    val navController = rememberNavController()
//
////    Button(
////        onClick = {
////            counterState.value++
//////            product.toString()
//////            navController.currentBackStackEntry?.arguments?.putParcelable("putty", putty)
////   //         navController.navigate("putty_details")
////        }, modifier = Modifier.padding(110.dp, 0.dp), colors = ButtonDefaults.buttonColors(
////            backgroundColor = Color.LightGray
////        )
////    ) {
////        if (counterState.value == 0) {
////            Text(text = "В корзину", fontSize = 14.sp)
////
////        } else
////            Text("${counterState.value}")
////    }
//    //ButtonAddToCart()
//
//}
//
//@Composable
//private fun PuttyImage(putty: Putty) {
//    Image(
//        painter = painterResource(id = putty.image), contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .padding(8.dp)
//            .size(92.dp, 92.dp)
//    )
//}
//
//@Composable
//private fun CusPuttyListItem(
//    putty: Putty,
//    cartState: Result<CartItem> = Result.Loading,
//    onAddPress: (putty: Putty) -> Unit = {}){
//
//    when(cartState) {
//        is Result.Success<CartItem> -> {
//            val cart = cartState.data
//            AddButtonToCart(putty = putty,
//            inCart = cart.putty.contains(putty),
//            onAddPress = {putty -> onAddPress(putty)  })
//        }
//    }
//}
//@Composable
//fun AddButtonToCart(putty: Putty, inCart: Boolean = false, onAddPress: (putty : Putty) -> Unit = {}) {
//    val counterState = remember { mutableStateOf(0) }
//   if (inCart && counterState.value ==0) {
//       Text(text = "В корзину", fontSize = 14.sp)
//   } else
//       Button(onClick = { onAddPress(putty) }) {
//           Text("${counterState.value}")
//       }
//}
////@Composable
////fun ButtonAddToCart(){
////
////    val counterState = remember { mutableStateOf(0) }
////    Button(
////        onClick = {
////            counterState.value++
////        }, modifier = Modifier.padding(110.dp, 0.dp), colors = ButtonDefaults.buttonColors(
////            backgroundColor = Color.LightGray
////        )
////    ) {
////        if (counterState.value == 0) {
////            Text(text = "В корзину", fontSize = 14.sp)
////
////        } else
////            Text("${counterState.value}")
////    }
////}
