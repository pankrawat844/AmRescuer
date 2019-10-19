package com.app.amrescuer.activity.feeddetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.app.amrescuer.R
import kotlinx.android.synthetic.main.activity_feed_detail.view.*

class FeedDetailActivity : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_feed_detail, container, false)
        sharedElementEnterTransition = androidx.transition.TransitionInflater.from(activity).inflateTransition(android.R.transition.move)
        ViewCompat.setTransitionName(view.img, view.img.transitionName)
        return view
    }
}
