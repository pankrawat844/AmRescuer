package com.app.amrescuer.network

import com.app.amrescuer.room.entities.Feed

data class FeedsResponse(
        val success:Boolean,
        val response:List<Feed>
)