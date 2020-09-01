package com.shivam.newsy

import com.squareup.moshi.Json

data class TopStories(
    @Json(name = "status")
    val status: String,
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "section")
    val section: String,
    @Json(name = "last_updated")
    val lastUpdated: String,
    @Json(name = "results")
    val articles: List<Article>
)