package com.app.amrescuer.repositories

import android.util.Log
import com.app.amrescuer.network.AuthResponse
import com.app.amrescuer.network.MyApi
import com.app.amrescuer.network.SafeApiRequest
import com.app.amrescuer.network.SignupResponse
import com.app.amrescuer.room.AppDatabase
import com.app.amrescuer.room.entities.User
import retrofit2.Response

class UserRepository(
        private val api:MyApi,
        private val db:AppDatabase
) :SafeApiRequest(

){
        suspend  fun Userlogin(email:String, password:String):AuthResponse{

            return  apiRequest{api.userLogin(email,password)}

}

    suspend fun saveUser(user: User)=db.getUserDao().updatenInsert(user)

    suspend fun signupUser(
            name:String,
            email: String,
            password: String,
            mobile:String
    ):SignupResponse
    {
//        Log.e("response",apiRequest{api.uerSignup(name,email,password,mobile)}.response!!)
        return apiRequest{api.uerSignup(name,email,password,mobile)}
    }
    fun getUser()=db.getUserDao().getUserData()
}