package com.example.coroutinetest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.coroutinetest1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            btnStart.setOnClickListener {
                btnStart.visibility = View.GONE

                CoroutineScope(Dispatchers.Main).launch {
                    DownloadManager.downloadInfo()
                }
            }
            btnCancel.setOnClickListener {
                progressWrap.visibility = View.VISIBLE
            }
        }
    }
}