package com.max.leroymerlinchebmax.catalog.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.max.leroymerlinchebmax.catalog.models.Putty
import com.max.leroymerlinchebmax.R
import com.max.leroymerlinchebmax.Result
import com.max.leroymerlinchebmax.catalog.models.CusPutty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

object PuttyRepository: CustomPuttyRepo {
    private var catalogData: CusPutty? = null

    @Suppress("ObjectPropertyName")
    private val _result = MutableStateFlow<Result<CusPutty>>(Result.Loading)
    private val result: StateFlow<Result<CusPutty>> = _result


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

    override fun observeCustomPutty(): StateFlow<Result<CusPutty>> {
        return result
    }

    override suspend fun loadCatalog() {
        _result.value = Result.Loading

        if (catalogData != null) {
            _result.value = Result.Success(catalogData!!)
            return
        }else

        try {
            val data = withContext(Dispatchers.IO) {
//                service.loadCatalog()
                delay(500)
                CusPutty(getAllData())
            }
            catalogData = data

            _result.value = Result.Success(data)
        } catch (e: Exception) {
            _result.value = Result.Error(e)
        }
    }
}