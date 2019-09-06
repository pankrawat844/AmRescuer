package com.app.amrescuer.network

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login.php")
    suspend fun userLogin(@Field("email") email:String,
                  @Field("password") password:String):Response<AuthResponse>

    companion object{
        operator fun invoke(
                networkInterceptor: NetworkInterceptor
        ):MyApi{
            val okHttpClient= OkHttpClient.Builder()
                    .addInterceptor(networkInterceptor)
                    .build()
             return Retrofit.Builder()
                     .baseUrl("https://ukfashion.000webhostapp.com/am_secure/")
                     .client(okHttpClient)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
                     .create(MyApi::class.java)
        }
    }

}