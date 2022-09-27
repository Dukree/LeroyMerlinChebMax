package com.max.leroymerlinchebmax.catalog.repository

import com.max.leroymerlinchebmax.Result
import com.max.leroymerlinchebmax.catalog.models.CusPutty
import kotlinx.coroutines.flow.StateFlow

interface CustomPuttyRepo {
    fun observeCustomPutty(): StateFlow<Result<CusPutty>>
    suspend fun loadCatalog()
}