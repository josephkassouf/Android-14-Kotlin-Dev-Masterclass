package com.bap.kotlinbasics

import java.util.Calendar

class BookClass (
    private val title: String = "Unknown",
    private val author: String = "Anonymous",
    private val yearPublished: Int = Calendar.getInstance().get(Calendar.YEAR)
) {

    init {
        println("Book initialized: Title='$title', Author='$author', YearPublished=$yearPublished")
    }


    fun displayDetails() {
        println("Title: $title")
        println("Author: $author")
        println("Year Published: $yearPublished")
    }
}