package com.example.directory_compose.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T> {
    @SerializedName("success")
    var success: Int = 0
    @SerializedName("message")
    var message: String = ""
    @SerializedName("data")
    var data: T? = null
}