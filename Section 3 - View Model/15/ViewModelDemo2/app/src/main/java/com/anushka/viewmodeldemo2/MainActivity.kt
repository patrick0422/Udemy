package com.anushka.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.result.text = viewModel.sum.toString()

        binding.btnAdd.setOnClickListener {
            if (binding.input.text.isNotEmpty()) {
                viewModel.addValue(binding.input.text.toString().toInt())
                binding.result.text = viewModel.sum.toString()

                binding.input.text.clear()
            }
        }
    }
}