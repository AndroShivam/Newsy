package com.shivam.newsy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.shivam.newsy.databinding.FragmentCategoriesBinding
import com.shivam.newsy.CategoriesModel.categories


class CategoriesFragment : Fragment(),
    CategoriesAdapter.CategoryListener {

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CategoriesAdapter(categories, this)
        binding.categoriesRecyclerview.adapter = adapter
    }


    override fun onCategoryClicked(category: Category) {
        Toast.makeText(context, category.title, Toast.LENGTH_LONG).show()
        val action = CategoriesFragmentDirections.actionItemCategoriesToItemHome(category.title)
        findNavController().navigate(action)
    }
}