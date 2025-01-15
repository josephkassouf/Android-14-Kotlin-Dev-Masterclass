package com.bap.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish {
    val wishList: List<Wish> = listOf(
        Wish(title = "Buy a new car", description = "I need a new car for my family vacation."),
        Wish(title = "Buy a new phone", description = "I need a new phone for my new job."),
        Wish(title = "Buy a new computer", description = "I need a new computer to work from home.")
    )
}
