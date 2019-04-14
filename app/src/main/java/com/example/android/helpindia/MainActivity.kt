package com.example.android.helpindia

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.android.helpindia.Login.Main_Activitylogin

import com.example.android.helpindia.`class`.*
import com.example.android.helpindia.database.DBnews
import com.example.android.helpindia.database.newstable
import com.example.android.helpindia.signin.signinmain
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var actintent:Intent
    var newslist=ArrayList<News>()
    lateinit var newsadapter:newsrv

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        if(isConnected()) {

        }else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("No Internet Connection")
            builder.setMessage("You need to have Mobile Data or wifi to  access this. Press ok to Exit")


            builder.setPositiveButton("Ok",  { dialogInterface: DialogInterface, i: Int ->
                finish()
            })
            builder.show()
        }

        //val db=DBnews(this).writableDatabase
        rvmain.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        /*fun refreshTodos()
        {
            newslist.clear()
         //   newslist.addAll(newstable.getAllTasks(db))
            newsadapter.notifyDataSetChanged()
        }
        val ontaskdelete={
            task:News->
            //newstable.delete(db,task)
            refreshTodos()
        }*/
        newsadapter=newsrv(newslist)

        val db=FirebaseDatabase.getInstance().getReference()
        db.child("news").keepSynced(true)
        db.child("news").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                newslist.clear()
                val children = p0.children
                for (child in children)
                {
                    val value: News? = child.getValue(News::class.java)
                    if (value != null) {
                        newslist.add(value)
                    }

                }
                newsadapter.notifyDataSetChanged()


            }

        })

        rvmain.adapter=newsadapter
        //refreshTodos()




        btnngo.setOnClickListener({
            actintent= Intent(this,Main2Activity::class.java)
            startActivity(actintent)
        })

        btnadoption.setOnClickListener({
            actintent= Intent(this,Main3Activity::class.java)
            startActivity(actintent)
        })
        /*btnarmy.setOnClickListener({
            actintent= Intent(this,Main4Activity::class.java)
            startActivity(actintent)
        })*/
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
        /*btnmore.setOnClickListener({
            Toast.makeText(this,"under constriction",Toast.LENGTH_SHORT).show()
        })*/

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    fun buildDialog(c: Context): AlertDialog.Builder {

        val builder = AlertDialog.Builder(c)
        builder.setTitle("No Internet Connection")
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit")


        builder.setPositiveButton("Ok",  object :DialogInterface.OnClickListener{

            override fun onClick(dialog: DialogInterface?, which: Int) {
                finish()
            }
        });

        return builder
    }
    fun isConnected():Boolean  {

       val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as (ConnectivityManager);
       val netinfo = cm.getActiveNetworkInfo();

        /*if (netinfo != null && netinfo.isConnectedOrConnecting())
        {
            val wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            val  mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
        return false;
    */
    return netinfo!=null && netinfo.isConnected
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
                   actintent= Intent(this,ContactActivity::class.java)
                startActivity(actintent)
            }
            R.id.nav_manage -> {
                actintent=Intent(this,SettingsActivity::class.java)
                startActivity(actintent)
            }
            R.id.login -> {
                actintent= Intent(this, Main_Activitylogin::class.java)
                startActivity(actintent)

            }
            R.id.signin -> {
                 actintent= Intent(this, signinmain::class.java)
                startActivity(actintent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
