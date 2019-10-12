package com.app.amrescuer.fragment.feed

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.app.amrescuer.R
import com.app.amrescuer.databinding.FeedInsertFragmentBinding

class FeedInsertActivity :AppCompatActivity() {

    companion object {
        fun newInstance() = FeedInsertActivity()
    }

//    private lateinit var viewModel: FeedInsertViewModel
    lateinit var databinding:FeedInsertFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this,R.layout.feed_insert_fragment)
       val viewModel:FeedInsertViewModel=ViewModelProviders.of(this).get(FeedInsertViewModel::class.java)
        databinding.lifecycleOwner=this

    }

}
