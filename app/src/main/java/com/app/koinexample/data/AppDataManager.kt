package com.app.koinexample.data

import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import com.app.koinexample.model.User

class AppDataManager(
    var api: RandomUserAPI,
    var database: RandomUserDatabase,
    var preferenceHelper: AppPreferenceHelper
) : DataManager {


    override suspend fun getRandomUserFromDatabase(): List<User>? {
        return database.userDao().getAllUsers()
    }

    override suspend fun insertDataForFirstTime(): List<User>? {
        return if (!preferenceHelper.isDataInserted())
            getRandomUserFromApi().also {
                preferenceHelper.dataInsertedSuccessFully()
            }
        else
            getRandomUserFromDatabase()
    }

    override fun isDataInserted(): Boolean {
        return preferenceHelper.isDataInserted()
    }

    override suspend fun getRandomUserFromApi(): List<User>? {
        return api.getRandomUser("foobar", "10").await().results?.also {
            insertUserIntoDatabase(it)
        }
    }

    override suspend fun insertUserIntoDatabase(user: List<User>) {
        database.userDao().insert(user)
    }

    override suspend fun getUserByEmail(email: String): User {
        return database.userDao().getUserByEmail(email)
    }
}