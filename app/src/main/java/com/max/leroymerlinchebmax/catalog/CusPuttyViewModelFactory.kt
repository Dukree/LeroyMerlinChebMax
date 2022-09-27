package com.max.leroymerlinchebmax.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.leroymerlinchebmax.catalog.repository.PuttyRepository
import com.max.leroymerlinchebmax.cart.repository.PuttyCartRepo


class CusPuttyViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val customPuttyRepo = PuttyRepository
        val cartRepo = PuttyCartRepo

         @Suppress("UNCHECKED_CAST")
        return CustomPuttyViewModel(
            customPuttyRepo = customPuttyRepo,
            cartRepo = cartRepo
        ) as T
    }

}