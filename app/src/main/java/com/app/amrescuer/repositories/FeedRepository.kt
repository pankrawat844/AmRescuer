package com.app.amrescuer.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.amrescuer.network.MyApi
import com.app.amrescuer.network.SafeApiRequest
import com.app.amrescuer.room.AppDatabase
import com.app.amrescuer.room.entities.Feed
import com.app.amrescuer.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedRepository(
        private val api: MyApi,
        private val db:AppDatabase
):SafeApiRequest() {

    private val feeds=MutableLiveData<List<Feed>>()

    init {

        feeds.observeForever {
            saveFeeds(it)
        }
    }

    private fun saveFeeds(it: List<Feed>) {
        Coroutines.io {
        db.getFeedsDao().saveAllFeeds(it)
    }
    }

    suspend fun getFeeds() :LiveData<List<Feed>>{
        return withContext(Dispatchers.IO){
            fetchFeeds()
            db.getFeedsDao().getAllFeeds()
        }
    }

    private suspend fun fetchFeeds()
    {
        if(isFetchNeeded())
        {
            val apiRequest=apiRequest { api.getFeeds() }
            feeds.postValue(apiRequest.response)
        }
    }

    private fun isFetchNeeded(): Boolean {
        return true
    }
}