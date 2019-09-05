package com.app.amrescuer.activity.auth

import androidx.lifecycle.LiveData
import com.app.amrescuer.room.entities.User

interface LoginListner {

    fun onStarted()
    fun onFailure(message:String)
    fun onSuccess(user:User)
}