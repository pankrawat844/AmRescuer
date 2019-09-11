package com.app.amrescuer.fragment.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.amrescuer.repositories.FeedRepository

class DashboardViewFactory(
        private val repository: FeedRepository
):ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository) as T
    }
}