package com.max.leroymerlinchebmax.cart.repository

import com.max.leroymerlinchebmax.*
import com.max.leroymerlinchebmax.cart.models.CartItem
import com.max.leroymerlinchebmax.cart.models.add
import com.max.leroymerlinchebmax.cart.models.remove
import com.max.leroymerlinchebmax.catalog.models.Putty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

object PuttyCartRepo : CartRepo {
    private var cartData : CartItem? = null

    private val _result = MutableStateFlow<Result<CartItem>>(Result.Loading)
    private val result: StateFlow<Result<CartItem>> = _result

    private fun getAllData():List<Putty>{
        val itemNames = listOf(
            Putty(
                articleId = 0,
                image = R.drawable.danogips,
                title = "Шпаклёвка готовая финишная Danogips SuperFinish 18.1 кг",
                price = 1155,

                ),
            Putty(
                articleId = 1,
                image = R.drawable.knauf,
                title = "Шпаклёвка виниловая суперфинишная Knauf Ротбанд Паста 18 кг",
                price = 1155,

                ),
            Putty(
                articleId = 2,
                image = R.drawable.axton,
                title = "Шпаклёвка полимерная суперфинишная Axton 25 кг",
                price = 1155,

                ),
        )
        return itemNames.map { Putty(it.articleId,it.image,it.title,it.price) }
    }

    override fun observeCart(): StateFlow<Result<CartItem>> {
       return result
    }

    override suspend fun loadCart() {
        _result.value = Result.Loading

        if (cartData != null) {
            _result.value = Result.Success(cartData!!)
            return
        }
        try {
            val data = withContext(Dispatchers.IO) {
//                service.loadCart()
                delay(500)
                CartItem()
            }
            cartData = data

            _result.value = Result.Success(data)
        } catch (e: Exception) {
            _result.value = Result.Error(e)
        }
    }

    override suspend fun addCartItem(putty: Putty) {
        try {
            val data = withContext(Dispatchers.IO) {
                delay(100)

                cartData.add(putty)
            }
            cartData = data

            _result.value = Result.Success(data)
        } catch (e: Exception){
            _result.value = Result.Error(e)
        }
    }

    override suspend fun removeCartItem(putty: Putty) {
        try {
            val data = withContext(Dispatchers.IO){
                delay(100)
                cartData.remove(putty)
            }
            cartData = data

            _result.value = Result.Success(data)
        } catch (e: Exception) {
            _result.value = Result.Error(e)
        }
    }
}