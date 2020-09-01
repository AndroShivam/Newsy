package com.shivam.newsy


object CategoriesModel {

//     arts, automobiles, books, business, fashion, food, health, home, insider, magazine, movies, nyregion,
//    obituaries, opinion, politics, realestate, science, sports, sundayreview, technology, theater,
//    t-magazine, travel, upshot, us, and world.

    private val categories: MutableList<Category> = mutableListOf(
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
}

data class Category(
    val Image: Int,
    val title: Int
)