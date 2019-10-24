package com.app.koinexample.ui.splash

import com.app.koinexample.model.User

sealed class UserListState {
    object Loading : UserListState()
    class Success(val data: List<User>?) : UserListState()
    class Error(val error: Throwable) : UserListState()
}