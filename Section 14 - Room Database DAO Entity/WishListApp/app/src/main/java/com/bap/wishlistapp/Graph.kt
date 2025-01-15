package com.bap.wishlistapp

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bap.wishlistapp.data.Wish
import com.bap.wishlistapp.data.WishDatabase
import com.bap.wishlistapp.data.WishRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}