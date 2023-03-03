package com.example.myshop.data.database

import android.content.Context
import com.example.myshop.data.models.user.UserDbModel
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDbModel::class], version = 2)
abstract class ShopDatabase: RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: ShopDatabase? = null
        fun getInstance(context: Context): ShopDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, ShopDatabase::class.java, "database2"
                    ).build()
                }
                return instance
            }
        }
    }
}