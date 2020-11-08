package com.shivam.newsy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shivam.newsy.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.layout_error.view.*


class MainActivity : AppCompatActivity(), ArticleAdapter.ArticleListener {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.viewModel = viewModel

        initArticleList()

        binding.layoutError.error_btn.setOnClickListener { viewModel.retry() }

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = true
            viewModel.retry()
            binding.swipeRefreshLayout.isRefreshing = false
        }


        viewModel.result.observe(this, { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    val articles = result.data?.articles
                    adapter.submitList(articles)
                }
                //Status.ERROR -> showError(result.error)
                Status.LOADING -> adapter.submitList(emptyList())
                else -> Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }
        })
    }


    private fun initArticleList() {
        adapter = ArticleAdapter(listener = this)
        binding.homeRecyclerview.adapter = adapter
    }

    override fun onArticleClickedListener(article: Article) {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show()
    }


}

