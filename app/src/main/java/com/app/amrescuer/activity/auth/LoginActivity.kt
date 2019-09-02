package com.app.amrescuer.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.amrescuer.R
import com.app.amrescuer.utils.toast
import com.app.amrescuer.databinding.LoginBinding
import com.app.amrescuer.utils.hide
import com.app.amrescuer.utils.show
import kotlinx.android.synthetic.main.login.*
import kotlin.math.log

class LoginActivity : AppCompatActivity(),LoginListner {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bind:LoginBinding=DataBindingUtil.setContentView(this,R.layout.login)
        val viewModel:LoginViewModel=ViewModelProviders.of(this).get(LoginViewModel::class.java)
        bind.data=viewModel;
        viewModel.authListner=this
//            login.setOnClickListener {
//                if(!email.text.isEmpty() && !password.text.isEmpty()) {
//                    val intent = Intent(applicationContext, MainActivity::class.java)
//                    startActivity(intent)
//                }
//                    else
//                    Toast.makeText(this,"Please Enter Email And Password",Toast.LENGTH_SHORT).show()
//                }


            }

    override fun onStarted() {
    toast("Login Starteed")
        progress_bar.show()
    }

    override fun onFailure(message: String) {
        toast(message)
        progress_bar.hide()
    }

    override fun onSuccess(loginresponse: LiveData<String>) {
        loginresponse.observe(this, Observer {
            toast(it)
            progress_bar.hide()
        })
//    toast("Login Success")

    }
}
