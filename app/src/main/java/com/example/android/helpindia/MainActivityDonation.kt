package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.example.android.helpindia.`class`.donation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main_donation.*

class MainActivityDonation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_donation)
       // val empty:Editable=
        intent?.let { val name = intent.getStringExtra("name")
           // Log.e("name11", name)
            editText4.setText(name)
        }
        btnproceed.setOnClickListener({
            val obj=donation(
                    editText.text.toString()
                    ,editText2.text.toString(),
                    editText3.text.toString(),
                    editText4.text.toString()
            )

            val db=FirebaseDatabase.getInstance().getReference()
            val auth=FirebaseAuth.getInstance().currentUser
            if (auth != null) {
                db.child("login").child(auth.uid).child("donation").push().setValue(obj)
                Toast.makeText(this,"donated",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"you are not signned in ",Toast.LENGTH_SHORT).show()
            }
            editText.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")

        })
    }
}
