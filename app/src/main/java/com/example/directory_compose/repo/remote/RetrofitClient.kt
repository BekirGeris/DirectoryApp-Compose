package com.example.directory_compose.repo.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getClient(baseUrl:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
                .build()
        }
    }
}