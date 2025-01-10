package com.bap.listsobjects

fun main() {
    // Immutable List
    // val shoppingList = listOf("Processor", "RAM", "Graphics Card", "SSD")

    // Mutable List
    val mutableShoppingList = mutableListOf("Processor", "RAM", "Graphics Card", "SSD")
    mutableShoppingList.add("PSU")

    mutableShoppingList[1] = "RAM DDR4"

    if (mutableShoppingList.contains("PSU")) println("True")

    // Iterate through the list
    for (item in 0 until mutableShoppingList.size) {
        println("${item + 1}: ${mutableShoppingList[item]}")
    }

    println()

}
