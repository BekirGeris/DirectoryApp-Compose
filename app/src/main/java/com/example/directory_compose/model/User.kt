package com.example.directory_compose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user")
data class User(
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    @SerializedName("kisi_id")
    var userId: Int,
    @NotNull
    @ColumnInfo(name = "user_name")
    @SerializedName("kisi_ad")
    var userName: String,
    @NotNull
    @ColumnInfo(name = "user_tel")
    @SerializedName("kisi_tel")
    var userTel: String
) {
    override fun toString(): String {
        return "User(userId=$userId, userName='$userName', userTel='$userTel')"
    }
}
