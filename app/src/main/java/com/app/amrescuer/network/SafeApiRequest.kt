package com.app.amrescuer.network

import com.app.amrescuer.utils.ApiException
import org.json.JSONObject
import retrofit2.Response
import kotlin.text.StringBuilder

abstract class SafeApiRequest
{
    suspend fun<T:Any> apiRequest(call:suspend()->Response<T>):T
    {
        val response=call.invoke()
        if(response.isSuccessful)
        {
            return response.body()!!
        }else
        {
            val err=response.errorBody()?.string()
            val message=StringBuilder()
            err?.let {
                try {
                 message.append(JSONObject(it).getString("response"))
                }catch (e:Exception)
                {

                }
                message.append("\n")
            }
            message.append("Error Code ${response.code()}")
            throw ApiException(message.toString())
        }
    }
}