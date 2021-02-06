package com.example.yeexcom.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yeexcom.data.dao.UserDao
import com.example.yeexcom.data.model.LoggedInUser

@Database(version = 1,entities = [LoggedInUser::class])
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        private var instance:UserDatabase?=null
        @Synchronized
        fun getUserDatabase(context: Context):UserDatabase{
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext
            ,UserDatabase::class.java,"user_database")
                .build().apply {
                    instance=this
                }
        }
    }
}