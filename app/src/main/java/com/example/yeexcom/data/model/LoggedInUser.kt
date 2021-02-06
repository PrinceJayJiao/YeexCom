package com.example.yeexcom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@Entity
data class LoggedInUser(
    val userName: String,
    val password: String,
    val displayName:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}