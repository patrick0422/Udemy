package com.example.navdemo2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

object UserViewModel: ViewModel() {
    var userName = ""
    var userEmail = ""

    fun getMessage() = "Welcome, $userName"
}