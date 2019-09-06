package com.app.amrescuer.activity.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.app.amrescuer.repositories.UserRepository
import com.app.amrescuer.utils.ApiException
import com.app.amrescuer.utils.Coroutines
import com.app.amrescuer.utils.NoInternetConnection

class LoginViewModel(
        private val respositer:UserRepository

):ViewModel()
{
    var email:String?=null
    var password:String?=null
    var authListner:LoginListner?=null
    fun getLoggedinUser()= respositer.getUser()
    fun onLoginButtonClick(view:View)
    {
        authListner?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
        {
        authListner?.onFailure("Please Enter Email Or Password")
            return
        }

        Coroutines.main{
            try {
                val response=respositer.Userlogin(email!!,password!!)
                response?.response?.let {
                    authListner?.onSuccess(it)
                    respositer.saveUser(it)
                    return@main
                }
                authListner?.onFailure("Something went Wrong" )


            }catch (e:ApiException)
            {
                authListner?.onFailure(e.message!! )

            }catch (e:NoInternetConnection)
            {
                authListner?.onFailure(e.message!! )

            }



        }
    }
}