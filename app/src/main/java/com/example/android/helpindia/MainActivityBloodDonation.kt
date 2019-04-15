package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.helpindia.`class`.Blood
import com.example.android.helpindia.`class`.Workshop
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main_blood_donation.*

class MainActivityBloodDonation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_blood_donation)
        btnbd.setOnClickListener({
            val db= FirebaseDatabase.getInstance().getReference()
            val obj= Blood(etbdname.text.toString(),
                    etbdcity.text.toString(),
                    etbdtime.text.toString(),
                    etbddate.text.toString())
            val auth= FirebaseAuth.getInstance().currentUser
            if (auth != null) {
                db.child("login").child(auth.uid).child("bd").push().setValue(obj)
            }
            db.child("bd").push().setValue(obj)
            etbdname.setText("")
            etbdcity.setText("")
            etbdtime.setText("")
            etbddate.setText("")
            Toast.makeText(this,"published", Toast.LENGTH_SHORT).show()
        })
    }
}
