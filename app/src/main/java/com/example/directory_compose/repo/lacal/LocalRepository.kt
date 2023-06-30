package com.example.directory_compose.repo.lacal

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.directory_compose.data.db.AppDatabase
import com.example.directory_compose.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LocalRepository(context: Context) {
    var userList = MutableLiveData<List<User>>()
    var appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getInstance(context)!!
        userList = MutableLiveData()
    }

    fun getAllUsers() {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            userList.value = appDatabase.userDao().getAllUser()
        }
    }

    fun searchUser(searchText: String) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            userList.value = appDatabase.userDao().searchUser(searchText)
        }
    }

    fun saveUser(user: User) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            appDatabase.userDao().saveUser(user)
        }
    }

    fun updateUser(user: User) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            appDatabase.userDao().updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            appDatabase.userDao().deleteUser(user)
            getAllUsers()
        }
    }
}