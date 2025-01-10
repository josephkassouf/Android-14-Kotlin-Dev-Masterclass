package com.bap.kotlinbasics

class Dog (private val name: String) {

    init {
        bark()
    }

    private fun bark() {
        println("$name WOOF!")
    }
}