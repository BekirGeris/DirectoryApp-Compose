package com.example.directory_compose.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class UserForFirebase(
    var key: String? = "",
    var userName: String? = "",
    var userTel: String? = ""
) {
    fun toUser() : User {
        val key = this.key
        val name = this.userName
        val tel = this.userTel

        if (key != null && name != null && tel != null) {
            return User(0, name, tel, key)
        }
        return User(0, "", "", "")
    }
}