package com.app.amrescuer.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.amrescuer.room.entities.Feed

@Dao
    interface FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveAllFeeds(feeds:List<Feed>)

    @Query("select * from Feed")
     fun getAllFeeds():LiveData<List<Feed>>
}