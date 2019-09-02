package com.app.amrescuer.activity.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.app.amrescuer.repositories.UserRepository

class LoginViewModel:ViewModel()
{
    var email:String?=null
    var password:String?=null
    var authListner:LoginListner?=null
    fun onLoginButtonClick(view:View)
    {
        authListner?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
        {
        authListner?.onFailure("Please Enter Email Or Password")
            return
        }
        val loginresponse=UserRepository().Userlogin(email!!,password!!)
        authListner?.onSuccess(loginresponse)
    }
}