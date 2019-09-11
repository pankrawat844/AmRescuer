package com.app.amrescuer.fragment.profle

import androidx.lifecycle.ViewModel
import com.app.amrescuer.repositories.UserRepository

class ProfileViewModel(userRepository: UserRepository) : ViewModel()
{
    var name:String?=null
    var email:String?=null
    var passoword:String?=null
    var mobile:String?=null
    val user=userRepository.getUser()


}
