package com.app.amrescuer.network

import android.content.Context
import android.net.ConnectivityManager
import com.app.amrescuer.utils.NoInternetConnection
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(context: Context):Interceptor {

    val applicationContext=context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!IsinternetConnectionAvailable())
        throw NoInternetConnection("Please Make Sure You Have Active Internet Connection.")
        return chain.proceed(chain.request())
    }

    private fun IsinternetConnectionAvailable():Boolean
    {
        val connectivityManager=applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {
             return it!=null && it.isConnected
        }
    }
}