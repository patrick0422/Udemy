package com.example.recyclerviewdemo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val itemList: ArrayList<Fruit>, private val clickListener: (Fruit)->Unit): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)

        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position], clickListener)
    }

    override fun getItemCount(): Int = itemList.size
}
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.tvName)
    val supplier: TextView = itemView.findViewById(R.id.tvSupplier)

    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        name.text = fruit.name
        supplier.text = fruit.supplier

        itemView.setOnClickListener {
            clickListener(fruit)
        }
    }
}