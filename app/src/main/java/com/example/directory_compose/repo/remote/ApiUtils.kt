package com.example.directory_compose.repo.remote

class ApiUtils {
    companion object{
        private const val BASE_URL = "http://kasimadalan.pe.hu/"


        fun getRemoteRepository():RemoteRepository{
            return RetrofitClient.getClient(BASE_URL).create(RemoteRepository::class.java)
        }
    }
}