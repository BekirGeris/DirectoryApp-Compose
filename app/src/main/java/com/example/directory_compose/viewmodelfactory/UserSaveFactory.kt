package com.example.directory_compose.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.directory_compose.viewmodel.UserSaveViewModel

class UserSaveFactory(var application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserSaveViewModel(application) as T
    }
}