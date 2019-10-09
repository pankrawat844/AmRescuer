package com.app.amrescuer.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Feed(
        @PrimaryKey(autoGenerate = false)
        val id:String,
                val title:String,
                val message:String,
                val user_id:String,
                val image:String,
                val created_at:String,
                val likes:String,
                val comments:String)