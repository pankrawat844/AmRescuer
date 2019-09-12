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
import androidx.recyclerview.widget.LinearLayoutManager

import com.app.amrescuer.R
import com.app.amrescuer.room.entities.Feed
import com.app.amrescuer.utils.Coroutines
import com.app.amrescuer.utils.hide
import com.app.amrescuer.utils.show
import com.app.amrescuer.utils.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.dashboard_fragment.*
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
       bindUI()
    }

    private fun bindUI() =Coroutines.main {
        progress_bar.show()
        viewModel.feeds.await().observe(this, Observer {
            progress_bar.hide()
            initRecylerview(it.toFeedItem()  )
        })
    }

    private fun initRecylerview(toFeedItem: List<FeedItem>) {
        val adapt=GroupAdapter<ViewHolder>().apply {
            addAll(toFeedItem)
        }
        recyclerview.apply {
            layoutManager=LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter=adapt

        }
    }

    private fun List<Feed>.toFeedItem():List<FeedItem>{
        return this.map {
            FeedItem(it)
        }
    }

}
