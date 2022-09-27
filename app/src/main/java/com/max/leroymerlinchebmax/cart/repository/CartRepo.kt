package com.max.leroymerlinchebmax.cart.repository


import com.max.leroymerlinchebmax.catalog.models.Putty
import com.max.leroymerlinchebmax.Result
import com.max.leroymerlinchebmax.cart.models.CartItem
import kotlinx.coroutines.flow.StateFlow

interface CartRepo {
    fun observeCart(): StateFlow<Result<CartItem>>
    suspend fun loadCart()
    suspend fun addCartItem(putty: Putty)
    suspend fun removeCartItem(putty: Putty)

}