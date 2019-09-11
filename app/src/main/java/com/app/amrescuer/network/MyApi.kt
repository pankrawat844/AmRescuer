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
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import retrofit2.http.GET


interface MyApi {

    @FormUrlEncoded
    @POST("login.php")
    suspend fun userLogin(@Field("email") email:String,
                  @Field("password") password:String):Response<AuthResponse>

    @FormUrlEncoded
    @POST("signup.php")
    suspend fun uerSignup(
            @Field("name") name:String,
            @Field("email") email: String,
            @Field("password") password: String,
            @Field("mobile") mobile:String
    ):Response<SignupResponse>

    @GET("dashboard.php")
    suspend fun getFeeds():Response<FeedsResponse>
    companion object{
        operator fun invoke(
                networkInterceptor: NetworkInterceptor
        ):MyApi{
            val gson = GsonBuilder()
                    .setLenient()
                    .create()
            val okHttpClient= OkHttpClient.Builder()
                    .addInterceptor(networkInterceptor)
                    .build()
             return Retrofit.Builder()
                     .baseUrl("https://ukfashion.000webhostapp.com/am_secure/")
                     .client(okHttpClient)
                     .addConverterFactory(GsonConverterFactory.create(gson))
                     .build()
                     .create(MyApi::class.java)
        }
    }

}