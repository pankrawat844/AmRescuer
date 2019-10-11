package com.app.amrescuer.fragment.dashboard

import com.app.amrescuer.R
 import com.app.amrescuer.databinding.ItemDashboardBinding
import com.app.amrescuer.room.entities.Feed
import com.xwray.groupie.databinding.BindableItem

class FeedItem(
        private val feed:Feed
):BindableItem<ItemDashboardBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_dashboard
    }

    override fun bind(viewBinding: ItemDashboardBinding, position: Int) {
       viewBinding.feed=feed
    }
}