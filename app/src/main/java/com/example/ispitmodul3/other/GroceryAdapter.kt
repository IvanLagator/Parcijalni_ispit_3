package com.example.ispitmodul3.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ispitmodul3.R
import com.example.ispitmodul3.model.Grocery

interface OnItemClickListener {
    fun onItemClicked(grocery: Grocery)
}

class GroceryAdapter : RecyclerView.Adapter<GroceryAdapter.GroceryHolder>() {

    var groceries: List<Grocery> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: OnItemClickListener? = null


    inner class GroceryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvGrocery: TextView = itemView.findViewById(R.id.tvGroceryName)
        var tvCalories: TextView = itemView.findViewById(R.id.tvNumberOfCalories)
        init {
            itemView.setOnClickListener {
                if (position != RecyclerView.NO_POSITION){
                    onItemClickListener?.onItemClicked(groceries[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grocery_item, parent, false)
        return GroceryHolder(itemView)
    }

    override fun getItemCount(): Int {
        return groceries.size
    }

    override fun onBindViewHolder(holder: GroceryHolder, position: Int) {
        val currentUser = groceries[position]
        holder.tvGrocery.text = currentUser.name
        holder.tvCalories.text = currentUser.calories.toString()
    }
}