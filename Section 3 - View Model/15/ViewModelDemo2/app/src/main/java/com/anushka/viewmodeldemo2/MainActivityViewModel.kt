package com.anushka.viewmodeldemo2

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var sum = 0
    fun addValue(i: Int) {
        sum += i
    }
}