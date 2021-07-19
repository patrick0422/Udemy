package com.anushka.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private val total = MutableLiveData<Int>(startingTotal)
    val totalData: LiveData<Int>
    get() = total

    fun setTotal(input:Int){
        total.value!!.plus(input)
    }
}