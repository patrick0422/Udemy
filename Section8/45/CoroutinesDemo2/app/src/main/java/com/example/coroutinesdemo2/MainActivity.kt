package com.example.coroutinesdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            for (i in 1..200000) {
                Log.d("Patrick", "${i}. ${Thread.currentThread().name}")
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..200000) {
                Log.d("Patrick", "${i}. ${Thread.currentThread().name}")
            }
        }
    }
}