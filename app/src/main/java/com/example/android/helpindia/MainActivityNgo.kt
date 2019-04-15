package com.example.android.helpindia

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import com.example.android.helpindia.`class`.Adoption
import com.example.android.helpindia.`class`.Ngo
import com.example.android.helpindia.`class`.ngomainrv
import com.example.android.helpindia.`class`.ngorv
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main_ngo.*
import java.io.IOException

var number=0

class MainActivityNgo : AppCompatActivity() {
    var ngolist=ArrayList<Ngo>()
    var adoplist=ArrayList<Adoption>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ngo)
        val db= FirebaseDatabase.getInstance().getReference()
        db.keepSynced(true)
       /* intent?.let {
            val no = it.getStringExtra("number")
            Log.e("number",no.toString())
             number = Integer.parseInt(no.toString())
        }*/
btnngodonate.setOnClickListener({
    val name=ngoname.text
    val intent=Intent(this,MainActivityDonation::class.java)
    intent.putExtra("name",name)
    startActivity(intent)

})
        db.child("ngo").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val children: MutableIterable<DataSnapshot> = p0.children
                for(child in children){
                    val value: Ngo? = child.getValue(Ngo::class.java)
                    if (value != null) {
                        ngolist.add(value)
                    }
for(i in ngolist) {  //Log.e("check", ngolist[number].name)
    intent?.let {
        val no = it.getStringExtra("number")
        // Log.e("number", no.toString())
if(no==i.name) {
//    number = Integer.parseInt(no.toString())
    ngoname.text =i.name
    ngocause.text ="Cause: "+ i.cause
    ngotype.text = "Type: "+i.type
    ngocity.text ="City: "+  i.city
    ngoemailid.text="Email Id: "+i.emailid
    rvngomain.layoutManager=GridLayoutManager(this@MainActivityNgo,1, RecyclerView.HORIZONTAL,false)
    btnvisit.setOnClickListener({
        try {


            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(i.url1))
//intent.action=Intent.
            //i.url1="http://www.stackoverflow.com"
            //intent.data = Uri.parse(i.url1)
            startActivity(intent)
        }
 catch (e:Exception){
     Toast.makeText(this@MainActivityNgo,"website is not found",Toast.LENGTH_SHORT).show()

 }   })
    val adapter=ngomainrv(i.url)
    rvngomain.adapter=adapter
    adapter.notifyDataSetChanged()
}
    else{
    Log.e("check","does not exist")
}}
}
                }

            }

        })

        db.child("adoption").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                val children: MutableIterable<DataSnapshot> = p0.children
                for (child in children) {
                    val value: Adoption? = child.getValue(Adoption::class.java)
                    if (value != null) {
                        adoplist.add(value)
                    }

                }
                for (i in adoplist) {
                    intent?.let {
                        val no = it.getStringExtra("numbe")
                        // Log.e("number", no.toString())
                        if (no == i.name) {
                            ngoname.text = i.name

                            ngoemailid.text="Email Id: "+i.emailid
                            ngotype.text = "Type: "+i.type
                            ngocity.text = "City: "+ i.city



                                btnvisit.setOnClickListener({
                                    try {


                                        val intent = Intent(Intent.ACTION_VIEW)
                                        //i.url1="http://www.stackoverflow.com"
                                        //  val str="http://www.stackoverflow.com"
                                        intent.data = Uri.parse(i.url1)
                                        startActivity(intent)
                                    }
                                    catch (e:Exception){
                                        Toast.makeText(this@MainActivityNgo,"website is not found",Toast.LENGTH_SHORT).show()
                                    }
                                })


                            rvngomain.layoutManager = GridLayoutManager(this@MainActivityNgo, 1, RecyclerView.HORIZONTAL, false)
                            val adapter: ngomainrv = ngomainrv(i.url2)
                            rvngomain.adapter = adapter
                            adapter.notifyDataSetChanged()
                        }
                    }
                }

            }
        })


    }
}
