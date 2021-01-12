package com.homework.uilistshomework

sealed class Item {
    data class Movie (val textMovieName: String): Item()
    data class Header(val text: String): Item()
    data class WatchedMovie(val title: String, val description: String, val image: Int) : Item()
}