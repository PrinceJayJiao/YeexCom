package com.example.yeexcom.data

import com.example.yeexcom.data.model.LoggedInUser
import java.lang.Exception

interface ThreaListener {
    fun onFinish(user: LoggedInUser)
    fun onStart()
}