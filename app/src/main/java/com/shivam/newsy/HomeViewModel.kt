package com.shivam.newsy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val articleRepository: ArticleRepository
    private var selectedSection: String = ""
    private var job: Job? = null

    private val _result = MutableLiveData<Resource<TopStories>>()
    val result: LiveData<Resource<TopStories>>
        get() = _result

    init {
        val articleService = ApiFactory.articleService
        articleRepository = ArticleRepository(articleService)
    }

    fun setSection(section: String) {
        if (section == selectedSection)
            selectedSection = section

        loadTopArticles()
    }

    private fun loadTopArticles() {
        job?.cancel()

        job = viewModelScope.launch(Dispatchers.Main) {
            _result.value = Resource.loading(null)
            _result.value = articleRepository.getTopArticles("home")
        }
    }

    fun retry() = loadTopArticles()
}