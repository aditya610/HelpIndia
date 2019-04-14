package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.method.TextKeyListener.clear
import android.util.Log
import com.example.android.helpindia.`class`.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.events_main.*
import java.util.ArrayList

class Main6Activity : AppCompatActivity() {
var event=ArrayList<Workshop>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events_main)


        val adapter=worshoprv(event)
        rvevent.layoutManager=LinearLayoutManager(this,
                RecyclerView.VERTICAL,false)
        val db= FirebaseDatabase.getInstance().getReference()
        db.keepSynced(true)
        db.child("event").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                event.clear()
                val children: MutableIterable<DataSnapshot> = p0.children
                for(child in children){
                    val value: Workshop? = child.getValue(Workshop::class.java)
                    if (value != null) {
                        Log.e("event",value.name)
                        event.add(value)
                        Log.e("array",event[0].name)
                    }
                    adapter.notifyDataSetChanged()

                }

            }

        })
       // Log.e("event",event[0].name)
        rvevent.adapter=adapter
    }
}
