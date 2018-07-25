package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.android.helpindia.`class`.Blood
import com.example.android.helpindia.`class`.bloodrv
import com.example.android.helpindia.`class`.generaterandomblood
import kotlinx.android.synthetic.main.bloodorgandonationmain.*

var blood=ArrayList<Blood>()
class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bloodorgandonationmain)
        blood= generaterandomblood()
        val adapter=bloodrv(blood)
        rvblood.layoutManager=LinearLayoutManager(this,
                RecyclerView.VERTICAL,false)
        rvblood.adapter=adapter
    }
}
