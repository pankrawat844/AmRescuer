package com.app.amrescuer.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.amrescuer.R
import com.app.amrescuer.activity.MainActivity
import com.app.amrescuer.utils.toast
import com.app.amrescuer.databinding.LoginBinding
import com.app.amrescuer.network.MyApi
import com.app.amrescuer.repositories.UserRepository
import com.app.amrescuer.room.AppDatabase
import com.app.amrescuer.room.entities.User
import com.app.amrescuer.utils.hide
import com.app.amrescuer.utils.show
import com.app.amrescuer.utils.snackbar
import kotlinx.android.synthetic.main.login.*
import kotlin.math.log

class LoginActivity : AppCompatActivity(),LoginListner {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api=MyApi()
        val db=AppDatabase(this)
        val repository=UserRepository(api,db)
        val factory= AuthViewModalFactory(repository)
        val bind:LoginBinding=DataBindingUtil.setContentView(this,R.layout.login)
        val viewModel:LoginViewModel=ViewModelProviders.of(this,factory).get(LoginViewModel::class.java)
        bind.data=viewModel;
        viewModel.authListner=this
//
        viewModel.getLoggedinUser().observe(this, Observer {
            user->
            if(user!=null){
                Intent(this,MainActivity::class.java).also {
                    it.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(it)
                }
            }
        })


            }

    override fun onStarted() {
//    toast("Login Starteed")
        progress_bar.show()
    }

    override fun onFailure(message: String) {
//        toast(message)
        relative.snackbar(message)
        progress_bar.hide()
    }

    override fun onSuccess(user: User) {
//            toast("${user.name} is Logged in")
        relative.snackbar("${user.name} logged in")
            progress_bar.hide()

//    toast("Login Success")

    }
}
