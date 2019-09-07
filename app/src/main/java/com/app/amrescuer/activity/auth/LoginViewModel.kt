package com.app.amrescuer.activity.auth

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.app.amrescuer.repositories.UserRepository
import com.app.amrescuer.room.entities.User
import com.app.amrescuer.utils.ApiException
import com.app.amrescuer.utils.Coroutines
import com.app.amrescuer.utils.NoInternetConnection

class LoginViewModel(
        private val respositer:UserRepository

):ViewModel()
{
    var name:String?=null
    var email:String?=null
    var password:String?=null
    var mobile:String?=null
    var passwordconfirm:String?=null
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

    fun OnCreateAccountClick(view:View)
    {
       Intent(view.context,SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


    fun OnSignupButtonClick(view: View){
        authListner?.onStarted()
        if(name.isNullOrEmpty())
        {
            authListner?.onFailure("Name Must Not Be Empty")
            return
        }
        if(email.isNullOrEmpty())
        {
            authListner?.onFailure("Email Must Not Be Empty")
            return
        }

        if(password.isNullOrEmpty())
        {
            authListner?.onFailure("Password Must Not Be Empty")
            return
        }
        if(mobile.isNullOrEmpty())
        {
            authListner?.onFailure("Mobile Must Not Be Empty")
            return
        }
        Coroutines.main {
            try {
                val response=respositer.signupUser(name!!,email!!,password!!,mobile!!)
                Log.e("response",response.toString())
                response.response?.let {
                    authListner?.onSuccess(it)
                    return@main
                }
                authListner?.onFailure("Something Went Wrong, Please Try Again.")
            } catch (e: ApiException) {
                authListner?.onFailure(e.message!!)
            }catch (e:NoInternetConnection){
                authListner?.onFailure(e.message!!)
            }
        }
    }
}