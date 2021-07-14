package com.example.myviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int): ViewModel() {
    private val total = MutableLiveData(startingTotal)
    val totalData: LiveData<Int>
    get() = total

    val input = MutableLiveData<String>()

    fun addTotal() {
        total.value = total.value?.plus(input.value!!.toInt())
    }
}