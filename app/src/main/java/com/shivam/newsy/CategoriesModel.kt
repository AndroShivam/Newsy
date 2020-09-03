package com.shivam.newsy

import com.shivam.newsy.SectionType.*
import java.io.Serializable


object CategoriesModel {

    val categories: MutableList<Category> = mutableListOf(
        Category(Arts, R.drawable.art, R.string.arts, false),
        Category(Automobiles, R.drawable.automobile, R.string.automobiles, false),
        Category(Books, R.drawable.book, R.string.books, false),
        Category(Business, R.drawable.business, R.string.business, false),
        Category(Fashion, R.drawable.fashion, R.string.fashion, false),
        Category(Food, R.drawable.food, R.string.food, false),
        Category(Health, R.drawable.health, R.string.health, false),
        Category(Movies, R.drawable.movies, R.string.movies, false),
        Category(Politics, R.drawable.politics, R.string.politics, false),
        Category(Science, R.drawable.science, R.string.science, false),
        Category(Sports, R.drawable.sports, R.string.sports, false),
        Category(Technology, R.drawable.technology, R.string.technology, false),
        Category(Travel, R.drawable.travel, R.string.travel, false),
        Category(World, R.drawable.world, R.string.world, false)
    )
}


data class Category(
    val type: SectionType,
    var Image: Int,
    val title: Int,
    val isChecked: Boolean
) : Serializable

sealed class SectionType {
    object Arts : SectionType()
    object Automobiles : SectionType()
    object Books : SectionType()
    object Business : SectionType()
    object Fashion : SectionType()
    object Food : SectionType()
    object Health : SectionType()
    object Movies : SectionType()
    object Politics : SectionType()
    object Science : SectionType()
    object Sports : SectionType()
    object Technology : SectionType()
    object Travel : SectionType()
    object World : SectionType()
}