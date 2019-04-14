package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.method.TextKeyListener.clear
import com.example.android.helpindia.`class`.Blood
import com.example.android.helpindia.`class`.Ngo
import com.example.android.helpindia.`class`.bloodrv
import com.example.android.helpindia.`class`.generaterandomblood
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.bloodorgandonationmain.*

var blood=ArrayList<Blood>()
class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bloodorgandonationmain)
      //  blood= generaterandomblood()
        val adapter=bloodrv(blood)
        rvblood.layoutManager=LinearLayoutManager(this,
                RecyclerView.VERTICAL,false)
        val db= FirebaseDatabase.getInstance().getReference()
        db.keepSynced(true)
        db.child("bd").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                blood.clear()
                val children: MutableIterable<DataSnapshot> = p0.children
                for(child in children){
                    val value: Blood? = child.getValue(Blood::class.java)
                    if (value != null) {

                        blood.add(value)
                    }
adapter.notifyDataSetChanged()
                }

            }

        })
        rvblood.adapter=adapter
    }
}
