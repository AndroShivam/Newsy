package com.shivam.newsy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_items.view.*

class CategoriesAdapter(private val list: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val categoryTitle = itemView.category_title

        fun bind(categoriesTest: Category){
            categoryTitle.text = categoriesTest.title.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_items, parent, false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categoriesTest: Category = list[position]
        holder.bind(categoriesTest)
    }

    override fun getItemCount(): Int = list.size
}