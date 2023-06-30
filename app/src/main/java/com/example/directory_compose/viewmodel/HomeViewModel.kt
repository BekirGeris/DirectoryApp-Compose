package com.example.directory_compose.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.directory_compose.model.User
import com.example.directory_compose.repo.local.UserDaoRepository

class HomeViewModel constructor(application: Application) : AndroidViewModel(application) {
    var userList = MutableLiveData<List<User>>()
    private var repo = UserDaoRepository(application)

    init {
        getAllUsers()
        userList = repo.userList
    }

    fun getAllUsers() {
        repo.getAllUsers()
    }

    fun searchUser(searchText: String) {
        repo.searchUser(searchText)
    }

    fun deleteUser(user: User) {
        repo.deleteUser(user)
    }
}