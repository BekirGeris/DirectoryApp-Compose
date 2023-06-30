package com.example.directory_compose.repo.remote

import com.example.directory_compose.model.BaseResponse
import com.example.directory_compose.model.UsersResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteRepository {
    @GET("kisiler/tum_kisiler.php")
    fun getAllUser(): Call<UsersResponse>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun searchUser(@Field("kisi_ad") searchText: String): Call<UsersResponse>

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun deleteUser(@Field("kisi_id") userId: Int): Call<BaseResponse<Any>>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun saveUser(
        @Field("kisi_ad") userName: String,
        @Field("kisi_tel") userTel: String
    ): Call<BaseResponse<Any>>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun updateUser(
        @Field("kisi_id") userId: Int,
        @Field("kisi_ad") userName: String,
        @Field("kisi_tel") userTel: String
    ): Call<BaseResponse<Any>>
}