package com.example.android.helpindia.signin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helpindia.Login.Loginindividual
import com.example.android.helpindia.Login.Main_Activitylogin
import com.example.android.helpindia.MainActivity
import com.example.android.helpindia.R
import com.example.android.helpindia.`class`.signinclass
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_indvisignin.*

class indvisignin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indvisignin)
        btnsigninIND.setOnClickListener({
            val obj = signinclass(
                    etsignemailid.text.toString(),
                    etsignname.text.toString(),
                    etsignmobile.text.toString(),
                    etsignaddress.text.toString()
            )
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            val db = FirebaseDatabase.getInstance().getReference()



            if (firebaseUser != null) {
                db.child("userid").push().setValue(firebaseUser.uid)
                db.child("login").child(firebaseUser.uid).child("individual").push().setValue(obj)
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        })

    }
}
