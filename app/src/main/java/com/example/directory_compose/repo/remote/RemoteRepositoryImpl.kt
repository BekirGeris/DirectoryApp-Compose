package com.example.directory_compose.repo.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.directory_compose.model.User
import com.example.directory_compose.model.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.directory_compose.model.BaseResponse

class RemoteRepositoryImpl {
    var userList = MutableLiveData<List<User>>()
    var remoteRepository: RemoteRepository = ApiUtils.getRemoteRepository()

    init {
        userList = MutableLiveData()
    }

    fun getAllUsers() {
        remoteRepository.getAllUser().enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                Log.d("bekbek", "getAllUsers response: ${response.body()?.success}")
                userList.value = response.body()?.users
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.d("bekbek", "getAllUsers onFailure message: ${t.message}")
                t.printStackTrace()
            }
        })
    }

    fun searchUser(searchText: String) {
        remoteRepository.searchUser(searchText).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                Log.d("bekbek", "searchUser response: ${response.body()?.success}")
                userList.value = response.body()?.users
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.d("bekbek", "searchUser onFailure message: ${t.message}")
                t.printStackTrace()
            }
        })
    }

    fun saveUser(user: User) {
        remoteRepository.saveUser(user.userName, user.userTel).enqueue(object : Callback<BaseResponse<Any>> {
            override fun onResponse(call: Call<BaseResponse<Any>>, response: Response<BaseResponse<Any>>) {
                Log.d("bekbek", "saveUser response: ${response.body()?.message}")
                getAllUsers()
            }

            override fun onFailure(call: Call<BaseResponse<Any>>, t: Throwable) {
                Log.d("bekbek", "saveUser onFailure message: ${t.message}")
                t.printStackTrace()
            }
        })
    }

    fun updateUser(user: User) {
        remoteRepository.updateUser(user.userId, user.userName, user.userTel).enqueue(object : Callback<BaseResponse<Any>> {
            override fun onResponse(call: Call<BaseResponse<Any>>, response: Response<BaseResponse<Any>>) {
                Log.d("bekbek", "updateUser response: ${response.body()?.message}")
                getAllUsers()
            }

            override fun onFailure(call: Call<BaseResponse<Any>>, t: Throwable) {
                Log.d("bekbek", "updateUser onFailure message: ${t.message}")
                t.printStackTrace()
            }
        })
    }

    fun deleteUser(user: User) {
        remoteRepository.deleteUser(user.userId).enqueue(object : Callback<BaseResponse<Any>> {
            override fun onResponse(call: Call<BaseResponse<Any>>, response: Response<BaseResponse<Any>>) {
                Log.d("bekbek", "deleteUser response: ${response.body()?.message}")
                getAllUsers()
            }

            override fun onFailure(call: Call<BaseResponse<Any>>, t: Throwable) {
                Log.d("bekbek", "deleteUser onFailure message: ${t.message}")
                t.printStackTrace()
            }
        })
    }
}