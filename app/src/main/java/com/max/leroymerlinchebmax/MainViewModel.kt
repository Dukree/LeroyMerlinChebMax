package com.max.leroymerlinchebmax

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val vm = MutableLiveData<String>()

    fun save(text: String){
        vm.value = text
    }
}