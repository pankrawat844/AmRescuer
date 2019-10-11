package com.app.amrescuer.fragment.feed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.amrescuer.R

class FeedInsert : Fragment() {

    companion object {
        fun newInstance() = FeedInsert()
    }

    private lateinit var viewModel: FeedInsertViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feed_insert_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedInsertViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
