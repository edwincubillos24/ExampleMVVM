package com.cubidevs.examplemvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val suma: MutableLiveData<Int> = MutableLiveData()
    val sumaDone: LiveData<Int> = suma

    fun realizarSuma(num1: Int, num2: Int) {
        suma.value = num1 + num2
    }

}