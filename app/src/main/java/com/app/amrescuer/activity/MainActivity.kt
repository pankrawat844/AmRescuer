package com.app.amrescuer.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.app.amrescuer.fragment.HomeFragment
import com.app.amrescuer.fragment.SliderFragment1
import com.app.amrescuer.R
import com.app.amrescuer.fragment.dashboard.DashboardFragment
import com.app.amrescuer.fragment.feed.FeedInsertActivity
import com.app.amrescuer.fragment.profle.ProfileFragment
import com.app.amrescuer.utils.BottomNavigationDrawerFragment
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)
        setSupportActionBar(appbar)

        fab_bar.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            startActivity(Intent(this,FeedInsertActivity::class.java))
        }

//        val navController=Navigation.findNavController(this,R.id.fragment)
//        appbar.setupWithNavController(navController)
//        NavigationUI.setupActionBarWithNavController(this,navController)
        val homeFragment= DashboardFragment()
        val trasation=supportFragmentManager.beginTransaction().replace(R.id.frame_layout,homeFragment)
        trasation.commit()



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.bottom_menu
                , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            android.R.id.home -> {

                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)

                return true
            }

            R.id.nav_gallery ->
            {
                val frag=SliderFragment1()
               val support= supportFragmentManager.beginTransaction().replace(R.id.frame_layout,frag)
                support.commit()
//                Toast.makeText(applicationContext,"clicked",Toast.LENGTH_LONG).show()
                return true
            }
        }
        return false
    }


}
