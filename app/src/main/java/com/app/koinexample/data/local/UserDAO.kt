package com.app.koinexample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.koinexample.model.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: List<User>)

    @Query("DELETE FROM User")
    suspend fun deleteAllUsers(): Int

    @Query("SELECT * FROM User WHERE email = :email")
    suspend fun getUserByEmail(email: String): User

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>


}