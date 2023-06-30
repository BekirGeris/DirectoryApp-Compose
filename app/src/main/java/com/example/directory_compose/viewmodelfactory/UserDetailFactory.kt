package com.example.directory_compose.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.directory_compose.viewmodel.UserDetailViewModel

class UserDetailFactory(var application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailViewModel(application) as T
    }
}