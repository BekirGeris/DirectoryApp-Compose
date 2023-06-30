package com.example.directory_compose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.directory_compose.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUser(): List<User>

    @Insert
    suspend fun saveUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user WHERE user_name like '%' || :searchText || '%'")
    suspend fun searchUser(searchText: String): List<User>
}