package com.example.yeexcom.data

import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import com.example.yeexcom.MainActivity
import com.example.yeexcom.YeexComApplication
import com.example.yeexcom.data.database.UserDatabase
import com.example.yeexcom.data.model.LoggedInUser
import com.example.yeexcom.ui.login.LoginActivity
import java.io.IOException
import java.lang.Exception
import kotlin.concurrent.thread

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    val userDao=UserDatabase.getUserDatabase(YeexComApplication.context).userDao()
    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            var user:LoggedInUser?=null
            getUser(username,object:ThreaListener{
                override fun onFinish(selectedUser: LoggedInUser) {
                    user=selectedUser
                }

                override fun onStart() {

                }
            })
            while (user==null){
                Thread.sleep(1000)

            }

            if (user!!.userName=="THIS_IS_NOT_AN_EXISTING_ACCOUNT")
                Toast.makeText(YeexComApplication.context,
                "账户不存在",Toast.LENGTH_SHORT).show()
            else{
                if (password!= user!!.password){
                    Toast.makeText(YeexComApplication.context,
                    "密码错误",Toast.LENGTH_SHORT).show()
                }else{
                    return Result.Success(user!!)
                }
            }
//             TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "1111","")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
    //select user by userName from the userDataBase
    private fun getUser(username: String,listener:ThreaListener){
        thread {
            listener.onStart()

            var user=userDao.getUserByUsername(username)
            if (user==null){
                user= LoggedInUser("THIS_IS_NOT_AN_EXISTING_ACCOUNT","","")
            }
            listener.onFinish(user)
        }
    }
}