package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.helpindia.`class`.Workshop
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main_events.*

class MainActivityEvents : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_events)
        btnevent.setOnClickListener({
            val db=FirebaseDatabase.getInstance().getReference()
            val obj=Workshop(eteventname.text.toString(),
                    eteventpuspose.text.toString(),
             eteventcity.text.toString()       ,
            eteventtime.text.toString()+"  "+eteventdate.text.toString(),
            eteventreason.text.toString())
            val auth=FirebaseAuth.getInstance().currentUser
            if (auth != null) {
                db.child("login").child(auth.uid).child("event").push().setValue(obj)
            }
         db.child("event").push().setValue(obj)
            eteventname.setText("")
            eteventpuspose.setText("")
            eteventcity.setText("")
            eteventtime.setText("")
            eteventdate.setText("")
            eteventreason.setText("")
            Toast.makeText(this,"published",Toast.LENGTH_SHORT).show()
        })
    }
}
