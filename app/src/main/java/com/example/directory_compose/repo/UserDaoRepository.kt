package com.example.directory_compose.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.directory_compose.model.User

class UserDaoRepository {
    var userList = MutableLiveData<List<User>>()

    init {
        userList = MutableLiveData()
    }

    fun getAllUsers() {
        val list = mutableListOf<User>()
        val u1 = User(1, "bekir", "45874865456")
        val u2 = User(2, "zeynep", "4964684355")
        val u3 = User(3, "ömer", "5754545")
        val u4 = User(4, "seda", "4546421658")

        for (i in 1..100) {
            list.add(u1)
            list.add(u2)
            list.add(u3)
            list.add(u4)
        }

        userList.value = list
    }

    fun searchUser(searchText: String) {
        Log.d("bekbek", "Search User search text: $searchText")
    }

    fun saveUser(user: User) {
        Log.d("bekbek", "saveUser : $user")
    }

    fun updateUser(user: User) {
        Log.d("bekbek", "updateUser : $user")
    }

    fun deleteUser(user: User) {
        Log.d("bekbek", "deleteUser : $user")
    }
}