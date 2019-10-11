package com.app.amrescuer.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Feed(
        @SerializedName("comments")
        val comments: String?,
        @SerializedName("created_at")
        val createdAt: String?,
        @PrimaryKey(autoGenerate = false)
        @SerializedName("id")
        val id: String,
        @SerializedName("image")
        val image: String?,
        @SerializedName("likes")
        val likes: String?,
        @SerializedName("message")
        val message: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("user_id")
        val userId: String?,
        @SerializedName("user_name")
        val userName: String?,
        @SerializedName("user_profile")
        val userProfile: String?)
