package com.app.amrescuer.network

import com.app.amrescuer.room.entities.User

data class AuthResponse (  val success:Boolean?,
val response: User?
)
{

}