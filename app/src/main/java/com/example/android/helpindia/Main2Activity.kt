package com.example.android.helpindia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.android.helpindia.R.id.rvmain2
import com.example.android.helpindia.`class`.Ngo
import com.example.android.helpindia.`class`.generaterandomngo
import com.example.android.helpindia.`class`.ngorv
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.ngo.*


var ngolist=ArrayList<Ngo>()
class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ngo)
        rvmain2.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false) as RecyclerView.LayoutManager?
        //ngolist= generaterandomngo()
        //Log.d("ngo",ngolist[1].name)
        val ngoadapter= ngorv(ngolist)
        val db=FirebaseDatabase.getInstance().getReference()

        db.keepSynced(true)
        db.child("ngo").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                ngolist.clear()
                val children: MutableIterable<DataSnapshot> = p0.children
                for(child in children){
                    val value: Ngo? = child.getValue(Ngo::class.java)
                    if (value != null) {
                        ngolist.add(value)
                    }
                    ngoadapter.notifyDataSetChanged()
                }
            }

        })

       // Log.d("adapter",ngoadapter.toString())


        rvmain2.adapter=ngoadapter

    }
}
