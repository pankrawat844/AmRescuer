package com.app.amrescuer.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.amrescuer.room.entities.CURRENT_USER_ID
import com.app.amrescuer.room.entities.User


@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatenInsert(user:User):Long

    @Query("select * from user where uid=$CURRENT_USER_ID")
    fun getUserData():LiveData<User>

}