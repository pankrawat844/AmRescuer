package com.app.amrescuer.fragment.dashboard

import androidx.lifecycle.ViewModel
import com.app.amrescuer.repositories.FeedRepository
import com.app.amrescuer.utils.lazyDeferred

class DashboardViewModel(
         repository: FeedRepository
) : ViewModel()
{
    val feeds by lazyDeferred { repository.getFeeds()}
}
