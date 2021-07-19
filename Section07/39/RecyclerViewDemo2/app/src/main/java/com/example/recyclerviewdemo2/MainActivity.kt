package com.example.recyclerviewdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val dummyList = arrayListOf(
        Fruit("Apple", "John"),
        Fruit("Banana", "Kim"),
        Fruit("Cherry", "Amy"),
        Fruit("Mango", "Chris"),
        Fruit("Grape", "William"),
        Fruit("Strawberry", "Eric"),
        Fruit("Melon", "Hank"),
        Fruit("Pear", "Emily"),
        Fruit("Apple", "John"),
        Fruit("Banana", "Kim"),
        Fruit("Cherry", "Amy"),
        Fruit("Mango", "Chris"),
        Fruit("Grape", "William"),
        Fruit("Strawberry", "Eric"),
        Fruit("Melon", "Hank"),
        Fruit("Pear", "Emily"),
    )

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = MyRecyclerViewAdapter(dummyList) { selectedItem: Fruit ->
                onItemSelected(
                    selectedItem
                )
            }
        }
    }
    private fun onItemSelected(fruit: Fruit) {
        Toast.makeText(this@MainActivity, "Name: ${fruit.name}, Supplier: ${fruit.supplier}", Toast.LENGTH_SHORT).show()
    }
}