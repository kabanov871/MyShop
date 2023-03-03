package com.example.myshop.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myshop.data.models.user.UserDbModel

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(userModel: UserDbModel)

    @Query("SELECT EXISTS (SELECT 1 FROM user_table WHERE first_name = :firstName)")
    fun checkUser(firstName: String): Boolean

}