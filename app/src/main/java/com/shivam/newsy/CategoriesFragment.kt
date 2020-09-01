package com.shivam.newsy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.shivam.newsy.databinding.FragmentCategoriesBinding
import kotlinx.android.synthetic.main.fragment_home.*


class CategoriesFragment : Fragment() {


    private val categories = listOf(
        Category(R.mipmap.ic_launcher, R.string.arts),
        Category(R.mipmap.ic_launcher, R.string.automobiles),
        Category(R.mipmap.ic_launcher, R.string.books),
        Category(R.mipmap.ic_launcher, R.string.business),
        Category(R.mipmap.ic_launcher, R.string.fashion),
        Category(R.mipmap.ic_launcher, R.string.food),
        Category(R.mipmap.ic_launcher, R.string.health),
        Category(R.mipmap.ic_launcher, R.string.home),
        Category(R.mipmap.ic_launcher, R.string.movies),
        Category(R.mipmap.ic_launcher, R.string.opinion),
        Category(R.mipmap.ic_launcher, R.string.politics),
        Category(R.mipmap.ic_launcher, R.string.science),
        Category(R.mipmap.ic_launcher, R.string.sports),
        Category(R.mipmap.ic_launcher, R.string.technology),
        Category(R.mipmap.ic_launcher, R.string.travel),
        Category(R.mipmap.ic_launcher, R.string.us),
        Category(R.mipmap.ic_launcher, R.string.world)
    )

    private lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoriesRecyclerview.adapter = CategoriesAdapter(categories)
    }
}