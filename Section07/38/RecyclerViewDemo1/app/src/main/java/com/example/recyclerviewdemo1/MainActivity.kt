package com.example.recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val f = arrayListOf("Mango", "Apple", "Banana", "Guava", "Lemon", "Pear", "Orange")
    val fruitList = arrayListOf(
        Fruit("Mango", "Tom"),
        Fruit("Apple", "Daniel"),
        Fruit("Banana", "Jerry"),
        Fruit("Guava", "Frank"),
        Fruit("Lemon", "Eric"),
        Fruit("Pear", "David"),
        Fruit("Orange", "Amy"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.apply {
            this.setBackgroundColor(Color.YELLOW)
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = MyRecyclerViewAdapter(fruitList)
        }
    }
}