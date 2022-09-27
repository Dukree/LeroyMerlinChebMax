package com.max.leroymerlinchebmax.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.leroymerlinchebmax.cart.repository.PuttyCartRepo

class CartViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = PuttyCartRepo

        @Suppress("UNCHECKED_CAST")
        return CartViewModel(
            repo = repository
        ) as T
    }
}