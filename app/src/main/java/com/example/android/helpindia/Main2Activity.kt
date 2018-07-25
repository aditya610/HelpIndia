package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.android.helpindia.`class`.Ngo
import com.example.android.helpindia.`class`.generaterandomngo
import com.example.android.helpindia.`class`.ngorv
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.ngo.*


var ngolist=ArrayList<Ngo>()
class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ngo)
        rvmain2.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        ngolist= generaterandomngo()
        //Log.d("ngo",ngolist[1].name)
        val ngoadapter= ngorv(ngolist)
       // Log.d("adapter",ngoadapter.toString())


        rvmain2.adapter=ngoadapter

    }
}
