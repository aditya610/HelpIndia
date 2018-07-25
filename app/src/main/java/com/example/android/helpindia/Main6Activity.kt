package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.android.helpindia.`class`.Workshop
import com.example.android.helpindia.`class`.generaterandomworshop
import com.example.android.helpindia.`class`.worshoprv
import kotlinx.android.synthetic.main.events_main.*
import java.util.ArrayList

class Main6Activity : AppCompatActivity() {
var event=ArrayList<Workshop>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events_main)
        event= generaterandomworshop()
        val adapter=worshoprv(event)
        rvevent.layoutManager=LinearLayoutManager(this,
                RecyclerView.VERTICAL,false)
        rvevent.adapter=adapter
    }
}
