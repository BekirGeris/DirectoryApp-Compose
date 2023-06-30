package com.example.directory_compose.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UsersResponse(@SerializedName("kisiler")
                    @Expose
                    var users:List<User>,
                    @SerializedName("success")
                    @Expose
                    var success:Int) {
}