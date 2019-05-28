package com.app.amrescuer.Utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app.amrescuer.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomNavigationDrawerFragment:BottomSheetDialogFragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       return inflater.inflate(R.layout.fragment_bottomsheet, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigation_view.setNavigationItemSelectedListener { menuItem ->

            when(menuItem!!.itemId)
            {
                R.id.nav_camera ->

                    Toast.makeText(context, "camera clicked", Toast.LENGTH_SHORT).show()
                         BottomSheetBehavior.STATE_HIDDEN-> dismiss()

            }
            this.dismiss()
            true
        }
    }
}