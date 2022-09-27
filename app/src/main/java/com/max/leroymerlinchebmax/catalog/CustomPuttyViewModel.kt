package com.max.leroymerlinchebmax.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.leroymerlinchebmax.cart.repository.CartRepo
import com.max.leroymerlinchebmax.catalog.models.Putty
import com.max.leroymerlinchebmax.catalog.repository.CustomPuttyRepo
import kotlinx.coroutines.launch

class CustomPuttyViewModel(
    private val cartRepo: CartRepo,
    private val customPuttyRepo : CustomPuttyRepo
) : ViewModel() {

    val cusPuttyState = customPuttyRepo.observeCustomPutty()
    val cartState = cartRepo.observeCart()

    init {
        loadCatalog()
        loadCart()
    }

    private fun loadCatalog() {
        viewModelScope.launch {
            customPuttyRepo.loadCatalog()
        }
    }

    private fun loadCart(){
        viewModelScope.launch {
            cartRepo.loadCart()
        }
    }

    fun addCartItem( putty: Putty) {
        viewModelScope.launch {
            cartRepo.addCartItem(putty)
        }
    }

}
