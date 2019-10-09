package com.app.amrescuer.fragment.dashboard

import com.app.amrescuer.R
import com.app.amrescuer.databinding.ItemDashboardBinding
import com.app.amrescuer.databinding.PostViewBinding
import com.app.amrescuer.room.entities.Feed
import com.xwray.groupie.databinding.BindableItem

class FeedItem(
        private val feed:Feed
):BindableItem<PostViewBinding>() {
    override fun getLayout(): Int {
        return R.layout.post_view
    }

    override fun bind(viewBinding: PostViewBinding, position: Int) {
       viewBinding.feed=feed
    }
}