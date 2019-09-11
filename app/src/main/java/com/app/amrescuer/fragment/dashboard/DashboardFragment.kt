package com.app.amrescuer.fragment.dashboard

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.app.amrescuer.R
import com.app.amrescuer.utils.Coroutines
import com.app.amrescuer.utils.toast
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class DashboardFragment : Fragment(),KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: DashboardViewModel
    private val factory:DashboardViewFactory by instance()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        val dashboard =DataBindingUtil.inflate(inflater,R.layout.dashboard_fragment,container,false)
//            viewModel=ViewModelProviders.of(this,factory).get(DashboardViewModel::class.java)
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(DashboardViewModel::class.java)
        Coroutines.main {
            val feeds=viewModel.feeds.await()
            feeds.observe(this, Observer {
                context?.toast(it.size.toString())
            })
        }
    }

}
