package com.bap.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name="wish-title")
    val title: String = "",
    @ColumnInfo(name="wish-desc")
    val description: String = ""
)

object DummyWish {
    val wishList: List<Wish> = listOf(
        Wish(title = "Buy a new car", description = "I need a new car for my family vacation."),
        Wish(title = "Buy a new phone", description = "I need a new phone for my new job."),
        Wish(title = "Buy a new computer", description = "I need a new computer to work from home.")
    )
}
