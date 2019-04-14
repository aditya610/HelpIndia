package com.example.android.helpindia.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helpindia.MainActivity
import com.example.android.helpindia.MainActivityBloodDonation
import com.example.android.helpindia.MainActivityEvents
import com.example.android.helpindia.R
import com.example.android.helpindia.`class`.signinclass2
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_loginngo.*
import javax.xml.transform.Templates

class Loginngo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginngo)
        val data=FirebaseDatabase.getInstance().getReference()
        val auth=FirebaseAuth.getInstance().currentUser
        if (auth != null) {
            data.child("login").child(auth.uid).child("ngo").addValueEventListener(object :ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    val children: MutableIterable<DataSnapshot> = p0.children
                    for(child in children){
                        val value: signinclass2? = child.getValue(signinclass2::class.java)
                        if (value != null) {
                            tvloginname.text=value.name.toString()
                            tvloginid.text=value.emailid.toString()
                            tvloginngo.text=value.organizationname.toString()
                            tvlogincity.text=value.city.toString()
                            tvlogincause.text=value.cause.toString()
                            tvlogintype.text=value.type.toString()
                        }

                    }
                }

            })
            btneventadd.setOnClickListener({
                val intent=Intent(
                        this,
                        MainActivityEvents::class.java
                )
                startActivity(intent)
            })
            btnbd.setOnClickListener({
                val intent=Intent(
                        this,
                        MainActivityBloodDonation::class.java
                )
                startActivity(intent)

            })
            btnsignin.setOnClickListener({
                AuthUI.getInstance().signOut(this).addOnCompleteListener(object :OnCompleteListener<Void>{
                    override fun onComplete(p0: Task<Void>) {
                        val intent=Intent(this@Loginngo,MainActivity::class.java)
                        startActivity(intent)
                    }

                })
            })
        }
        else{

        }

    }
}
