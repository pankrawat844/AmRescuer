package com.app.amrescuer.activity.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.app.amrescuer.R
import com.app.amrescuer.databinding.SignupBinding
import com.app.amrescuer.room.entities.User
import com.app.amrescuer.utils.hide
import com.app.amrescuer.utils.show
import com.app.amrescuer.utils.snackbar
import com.app.amrescuer.utils.toast
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.progress_bar
import kotlinx.android.synthetic.main.login.relative
import kotlinx.android.synthetic.main.signup.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(),LoginListner,KodeinAware {


    override val kodein by kodein()
    private val factory:AuthViewModalFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind:SignupBinding=DataBindingUtil.setContentView(this, R.layout.signup)
        val viewModel=ViewModelProviders.of(this,factory).get(LoginViewModel::class.java)
        bind.viewmodel=viewModel
        viewModel.authListner=this

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

//    toast("Login Success")

    }

    override fun onSuccess(msg: String) {
        toast(msg)

        progress_bar.hide()

        Intent(this,LoginActivity::class.java).also {
            it.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

}
