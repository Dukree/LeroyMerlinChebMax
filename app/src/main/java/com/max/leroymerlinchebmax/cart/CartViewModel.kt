package com.max.leroymerlinchebmax.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.leroymerlinchebmax.cart.repository.CartRepo
import com.max.leroymerlinchebmax.catalog.models.Putty
import kotlinx.coroutines.launch

class CartViewModel(
    private val repo : CartRepo
) : ViewModel() {

    val state = repo.observeCart()

    init {
        loadCart()
    }

    private fun loadCart(){
        viewModelScope.launch {
            repo.loadCart()
        }
    }

    fun removeCartItem( putty: Putty) {
        viewModelScope.launch {
            repo.removeCartItem(putty)
        }
    }
}