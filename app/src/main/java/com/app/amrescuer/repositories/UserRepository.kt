package com.app.amrescuer.repositories

import com.app.amrescuer.network.AuthResponse
import com.app.amrescuer.network.MyApi
import com.app.amrescuer.network.SafeApiRequest
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

    fun getUser()=db.getUserDao().getUserData()
}