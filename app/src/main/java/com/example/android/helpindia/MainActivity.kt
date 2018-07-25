package com.example.android.helpindia

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.android.helpindia.R.layout.ngo

import com.example.android.helpindia.`class`.*
import com.example.android.helpindia.database.DBnews
import com.example.android.helpindia.database.newstable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.firsthalf_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var actintent:Intent
    var newslist=ArrayList<News>()
    lateinit var newsadapter:newsrv

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val db=DBnews(this).writableDatabase
        rvmain.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        fun refreshTodos()
        {
            newslist.clear()
            newslist.addAll(newstable.getAllTasks(db))
            newsadapter.notifyDataSetChanged()
        }
        val ontaskdelete={
            task:News->
            newstable.delete(db,task)
            refreshTodos()
        }
        newsadapter=newsrv(newslist,ontaskdelete)
        rvmain.adapter=newsadapter
        refreshTodos()




        btnngo.setOnClickListener({
            actintent= Intent(this,Main2Activity::class.java)
            startActivity(actintent)
        })

        btnadoption.setOnClickListener({
            actintent= Intent(this,Main3Activity::class.java)
            startActivity(actintent)
        })
        btnarmy.setOnClickListener({
            actintent= Intent(this,Main4Activity::class.java)
            startActivity(actintent)
        })
        btnblooddonation.setOnClickListener({
            actintent= Intent(this,Main5Activity::class.java)
            startActivity(actintent)
        })
        btnworkshop.setOnClickListener(
                {
                    actintent= Intent(this,Main6Activity::class.java)
                    startActivity(actintent)
                }
        )
        btnmore.setOnClickListener({
            Toast.makeText(this,"under constriction",Toast.LENGTH_SHORT).show()
        })

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }
   fun add(new1:News)
   {
       newslist.add(new1)
       newsadapter.notifyDataSetChanged()

   }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.donation -> {
                actintent= Intent(this,MainActivityDonation::class.java)
                startActivity(actintent)
                // Handle the camera action
            }
            R.id.nav_gallery -> {
                actintent= Intent(this,MainActivityShareNews::class.java)
                startActivity(actintent)

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
