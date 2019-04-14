package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.android.helpindia.`class`.*
import kotlinx.android.synthetic.main.army_main.*

var army=ArrayList<Army>()

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.army_main)
        army= generaterandonarmy()

        rvarmy.layoutManager=LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        )
        val adapter=armyrv(army)
        rvarmy.adapter=adapter
    }
}
