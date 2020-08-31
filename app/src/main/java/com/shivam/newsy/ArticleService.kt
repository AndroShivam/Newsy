package com.shivam.newsy

import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {


    @GET("/svc/topstories/v2/{section}.json?api-key=${BuildConfig.NY_TIMES_API_KEY}")
    suspend fun getTopStories(@Path("section") section: String): TopStories
}