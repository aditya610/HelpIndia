package com.example.android.helpindia.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helpindia.MainActivity
import com.example.android.helpindia.MainActivityDonation
import com.example.android.helpindia.R
import com.example.android.helpindia.`class`.signinclass
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_loginindividual.*

class Loginindividual : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginindividual)
        val db = FirebaseDatabase.getInstance().getReference()
        val auth = FirebaseAuth.getInstance().currentUser
        if (auth != null) {
            db.child("login").child(auth.uid).child("individual").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    val children: MutableIterable<DataSnapshot> = p0.children
                    for (child in children) {
                        val value: signinclass? = child.getValue(signinclass::class.java)
                        if (value != null) {
                            tvloginname.text = value.name.toString()
                            tvloginemail.text = value.emailid.toString()
                            tvloginmobileno.text = value.mobileno.toString()
                            tvloginaddress.text = value.address.toString()
                        }
                    }

                }

            })
            btnlogindonate.setOnClickListener({
                val intent=Intent(this,MainActivityDonation::class.java)
                startActivity(intent)
            })
            btnindivlogout.setOnClickListener({
                AuthUI.getInstance().signOut(this).addOnCompleteListener(object : OnCompleteListener<Void> {
                    override fun onComplete(p0: Task<Void>) {
                        val intent = Intent(this@Loginindividual, MainActivity::class.java)
                        startActivity(intent)
                    }
                })
            })

        }
        else{

        }
    }
}