package com.example.directory_compose.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.directory_compose.model.User
import com.example.directory_compose.repo.UserDaoRepository

class UserSaveViewModel : ViewModel() {
    var repo = UserDaoRepository()

    fun saveUser(user: User) {
        repo.saveUser(user)
    }
}