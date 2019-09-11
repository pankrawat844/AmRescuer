package com.app.amrescuer.fragment.profle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.amrescuer.repositories.UserRepository

class ProfileViewmodelFactory(
        private val repository: UserRepository
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}