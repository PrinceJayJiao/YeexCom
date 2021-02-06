package com.example.yeexcom.data.dao

import androidx.room.*
import com.example.yeexcom.data.model.LoggedInUser

@Dao
interface UserDao {

    @Insert
    fun insertUser(loggedInUser: LoggedInUser):Long
    @Update
    fun updateUser(loggedInUser: LoggedInUser)
    @Query("select * from LoggedInUser")
    fun loadAllUsers():List<LoggedInUser>
    @Query("select * from loggedInUser where userName = :userName")
    fun getUserByUsername(userName:String):LoggedInUser
    @Delete
    fun deleteUser(loggedInUser: LoggedInUser)


}