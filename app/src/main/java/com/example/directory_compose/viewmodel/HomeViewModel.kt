package com.example.directory_compose.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.directory_compose.model.User
import com.example.directory_compose.repo.remote.FirebaseRepository

class HomeViewModel constructor(application: Application) : AndroidViewModel(application) {
    var userList = MutableLiveData<List<User>>()
    private var repo = FirebaseRepository()

    init {
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