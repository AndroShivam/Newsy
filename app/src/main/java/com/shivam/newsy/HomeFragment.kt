package com.shivam.newsy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shivam.newsy.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.layout_error.view.*


class HomeFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel

        binding.layoutError.error_btn.setOnClickListener { viewModel.retry() }

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = true
            viewModel.retry()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        initArticleList()
        viewModel.retry()

        viewModel.result.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    val articles = result.data?.articles
                    adapter.submitList(articles)
                }
                //Status.ERROR -> showError(result.error)
                Status.LOADING -> adapter.submitList(emptyList())
                else -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initArticleList() {
        adapter = ArticleAdapter()
        binding.homeRecyclerview.adapter = adapter
    }
}
