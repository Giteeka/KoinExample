package com.app.koinexample.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.app.koinexample.BaseObservableViewModel
import com.app.koinexample.DispatcherProvider
import com.app.koinexample.data.DataManager
import com.app.koinexample.model.User
import com.app.koinexample.ui.UserListState
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(var dataManager: DataManager, var dispatcherProvider: DispatcherProvider) : BaseObservableViewModel(){

    var TAG = "SplashViewModel"

    val state = MutableLiveData<UserListState>().apply {
        value = UserListState.Loading
    }

    val loading: LiveData<Boolean> = Transformations.map(state) {
        (it is UserListState.Loading)
    }

    val data: LiveData<List<User>> = Transformations.map(state) {
        (it as? UserListState.Success)?.data
    }

    val showData: LiveData<Boolean> = Transformations.map(state) {
        (it is UserListState.Success)
    }
    val error: LiveData<Boolean> = Transformations.map(state) {
        (it is UserListState.Error)
    }
    val errorMessage: LiveData<String> = Transformations.map(state) {
        (it as? UserListState.Error)?.error?.localizedMessage
    }

    fun loadData() {
        setState(UserListState.Loading)
        viewModelScope.launch {
            val newState = withContext(dispatcherProvider.IO) {
                try {
                    val users = dataManager.getRandomUserFromDatabase()
                    Log.e(TAG, "Total users: " + users?.size)
                    return@withContext UserListState.Success(users)
                } catch (e: Throwable) {
                    Log.e(TAG, "error: $e")
                    return@withContext UserListState.Error(e)
                }
            }
            setState(newState)
        }


    }

    private fun setState(newState: UserListState) {
        Log.e(TAG, "setting state : $newState")
        this.state.value = newState
        notifyChange()
    }
}