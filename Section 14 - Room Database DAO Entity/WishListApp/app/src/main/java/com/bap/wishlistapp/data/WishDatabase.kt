package com.bap.wishlistapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)

abstract class WishDatabase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}