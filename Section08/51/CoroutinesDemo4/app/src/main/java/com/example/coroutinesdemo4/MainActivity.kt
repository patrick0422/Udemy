package com.example.coroutinesdemo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinesdemo4.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        CoroutineScope(Main).launch {
            Log.i("Mytag", "Calculation started..")
            val stock1 = async(IO) { getStock1() }
            val stock2 = async(IO) { getStock2() }

            val total = stock1.await() + stock2.await()
            Log.i("Mytag", "total: $total")
        }
    }
}

private suspend fun getStock1(): Int {
    delay(10000)
    Log.i("MyTag", "stock 1 returned")

    return 55000
}
private suspend fun getStock2(): Int {
    delay(8000)
    Log.i("MyTag", "stock 2 returned")

    return 35000
}