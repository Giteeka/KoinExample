package com.app.koinexample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.koinexample.model.User

@Database(entities = [(User::class)], version = 1)
abstract class RandomUserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDAO

    companion object {
        private var INSTANCE: RandomUserDatabase? = null

        fun getInMemoryDatabase(context: Context): RandomUserDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    RandomUserDatabase::class.java, "RandomUserDatabase.db"
                ).build()
            }
            return INSTANCE!!
        }
    }
}