package com.example.directory_compose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user")
data class User(
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Int,
    @NotNull
    @ColumnInfo(name = "user_name")
    var userName: String,
    @NotNull
    @ColumnInfo(name = "user_tel")
    var userTel: String
) {
    override fun toString(): String {
        return "User(userId=$userId, userName='$userName', userTel='$userTel')"
    }
}
