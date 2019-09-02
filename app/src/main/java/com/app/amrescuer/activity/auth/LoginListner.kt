package com.app.amrescuer.activity.auth

import androidx.lifecycle.LiveData

interface LoginListner {

    fun onStarted()
    fun onFailure(message:String)
    fun onSuccess(loginresponse: LiveData<String>)
}