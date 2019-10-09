package com.app.amrescuer.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.amrescuer.room.entities.Feed
import com.app.amrescuer.room.entities.User
import java.util.concurrent.locks.Lock

@Database(
    entities=[User::class,Feed::class],
    version=1
)
abstract class AppDatabase:RoomDatabase()
{
abstract fun getUserDao():UserDao
abstract fun getFeedsDao():FeedDao
    companion object{
        @Volatile
        private var instance:AppDatabase?=null
        private val Lock=Any()
        operator fun invoke(context: Context)= instance?: synchronized(Lock)
        {
            instance ?: buildDatabase(context).also {
                instance=it
            }
        }
        private fun buildDatabase(context: Context)=
        Room.databaseBuilder(context.applicationContext,
                                AppDatabase::class.java,
                                "Mydatabase.db").build()

        }
}