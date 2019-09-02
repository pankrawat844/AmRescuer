package com.app.amrescuer.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.amrescuer.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class UserRepository {
    fun Userlogin(email:String, password:String):LiveData<String >{
    val loginresponse= MutableLiveData<String>()
    MyApi().userLogin(email,password)
            .enqueue(object :Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable)
                {
                    loginresponse.value=t.message
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>)
                {
                    if(response.isSuccessful)
                    {
                        loginresponse.value=response.body()?.string()
                    }else
                    {
                        loginresponse.value=response.errorBody()?.string()
                    }
                }

            })
return loginresponse
}
}