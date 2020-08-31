package com.shivam.newsy

class ArticleRepository(private val articleService: ArticleService) {
    private val responseHandler = ResponseHandler()

    suspend fun getTopArticles(section: String): Resource<TopStories> {
        return try {
            responseHandler.handleSuccess(articleService.getTopStories(section))
        } catch (e: Exception) {
            responseHandler.handleError(e)
        }
    }
}