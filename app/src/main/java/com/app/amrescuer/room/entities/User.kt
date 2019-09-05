package com.app.amrescuer.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID=0
@Entity
data class User (val id:String,
                 val name:String,
                 val password:String,
                 val email:String)
{
    @PrimaryKey(autoGenerate = false)
    var uid:Int= CURRENT_USER_ID
}