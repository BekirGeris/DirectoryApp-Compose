package com.example.directory_compose.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.directory_compose.model.User
import com.example.directory_compose.repo.local.UserDaoRepository

class UserDetailViewModel constructor(application: Application) : AndroidViewModel(application) {
    private var repo = UserDaoRepository(application)

    fun updateUser(user: User) {
        repo.updateUser(user)
    }
}