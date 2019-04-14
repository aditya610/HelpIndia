package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.android.helpindia.`class`.Adoption
import com.example.android.helpindia.`class`.adoptionrv
import com.example.android.helpindia.`class`.generaterandomadoption
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.adoption_main.*

var adoption=ArrayList<Adoption>()
class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adoption_main)
        val db=FirebaseDatabase.getInstance().getReference()

        val adapter=adoptionrv(adoption)
        db.keepSynced(true)
        db.child("adoption").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                adoption.clear()
                val children: MutableIterable<DataSnapshot> = p0.children
                for (child in children)
                {
                    val value: Adoption? = child.getValue(Adoption::class.java)
                    if (value != null) {
                        adoption.add(value)
                    }
adapter.notifyDataSetChanged()
                }

            }

        })
        rvadoption.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rvadoption.adapter=adapter
    }
}
