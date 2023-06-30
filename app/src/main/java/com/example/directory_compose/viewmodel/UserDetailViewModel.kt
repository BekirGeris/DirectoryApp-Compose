package com.example.directory_compose.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.directory_compose.model.User
import com.example.directory_compose.repo.lacal.LocalRepository
import com.example.directory_compose.repo.remote.FirebaseRepository
import com.example.directory_compose.repo.remote.RemoteRepositoryImpl

class UserDetailViewModel constructor(application: Application) : AndroidViewModel(application) {
    private var repo = FirebaseRepository()

    fun updateUser(user: User) {
        repo.updateUser(user)
    }
}