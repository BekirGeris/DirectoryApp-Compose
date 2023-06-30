package com.example.directory_compose.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.directory_compose.model.User
import com.example.directory_compose.repo.UserDaoRepository

class HomeViewModel : ViewModel() {
    var userList = MutableLiveData<List<User>>()
    var repo = UserDaoRepository()

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