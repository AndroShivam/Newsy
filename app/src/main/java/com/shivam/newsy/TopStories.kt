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

data class Article(
    @Json(name = "title")
    val title: String,
    @Json(name = "section")
    val section: String,
    @Json(name = "abstract")
    val description: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "uri")
    val uri: String,
    @Json(name = "subsection")
    val subsection: String,
    @Json(name = "byline")
    val byline: String,
    @Json(name = "short_url")
    val shortUrl: String,
    @Json(name = "published_date")
    val published_date: String,
    @Json(name = "multimedia")
    val multimedia: List<Multimedia>
)

data class Multimedia(
    @Json(name = "url")
    val url: String,
    @Json(name = "format")
    val format: String,
    @Json(name = "height")
    val height: Int,
    @Json(name = "width")
    val width: Int,
    @Json(name = "type")
    val type: String,
    @Json(name = "caption")
    val caption: String,
    @Json(name = "copyright")
    val copyright: String
)