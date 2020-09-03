package com.shivam.newsy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shivam.newsy.databinding.ArticleItemsBinding

class ArticleAdapter(private val listener: ArticleListener) :
    ListAdapter<Article, ArticleViewHolder>(ArticleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemsBinding.inflate(layoutInflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface ArticleListener {
        fun onArticleClickedListener(article: Article)
    }
}


class ArticleViewHolder(private val binding: ArticleItemsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Article, listener: ArticleAdapter.ArticleListener) {
        binding.apply {
            article = item
            root.setOnClickListener { listener.onArticleClickedListener(item) }
            executePendingBindings()
        }
    }
}

class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.uri == newItem.uri
    }
}

