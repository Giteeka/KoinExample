package com.app.koinexample.data

import com.app.koinexample.model.User

interface DataManager {

    suspend fun getRandomUserFromApi(): List<User>?

    suspend fun getRandomUserFromDatabase(): List<User>?

    suspend fun insertDataForFirstTime(): List<User>?

    suspend fun insertUserIntoDatabase(user: List<User>)

    suspend fun getUserByEmail(email: String): User

    fun isDataInserted(): Boolean

}