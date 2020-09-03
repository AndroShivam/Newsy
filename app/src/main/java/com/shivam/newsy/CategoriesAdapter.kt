package com.shivam.newsy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shivam.newsy.databinding.ArticleItemsBinding
import com.shivam.newsy.databinding.CategoryItemsBinding
import kotlinx.android.synthetic.main.category_items.view.*

class CategoriesAdapter(private val list: List<Category>, private val listener: CategoryListener) :
    ListAdapter<Category, CategoriesAdapter.CategoriesViewHolder>(CategoryDiffUtil()) {

    interface CategoryListener {
        fun onCategoryClicked(category: Category)
    }

    class CategoriesViewHolder(private val binding: CategoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category, listener: CategoryListener) {
            binding.apply {
                category = item
                categoryImg.setImageResource(item.Image)
                root.setOnClickListener { listener.onCategoryClicked(item) }
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context)
        val binding = CategoryItemsBinding.inflate(layoutInflater, parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = list[position]
        holder.bind(category, listener)
    }

    override fun getItemCount(): Int = list.size
}

class CategoryDiffUtil : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        TODO("Not yet implemented")
    }

}