package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.helpindia.R.id.*
import com.example.android.helpindia.`class`.News
import com.example.android.helpindia.`class`.newname
import com.example.android.helpindia.database.DBnews
import com.example.android.helpindia.database.newstable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main_donation.*
import kotlinx.android.synthetic.main.activity_main_share_news.*

class MainActivityShareNews : AppCompatActivity() {
    lateinit var new1:News
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_share_news)
       // val db= DBnews(this).writableDatabase
        btnpublish.setOnClickListener {
           // new1=News( Integer.valueOf(etphone.text.toString()),etheading.text.toString(),etnews.text.toString())
            // newstable.addTask(db,new1)
           val obj=News(
                   etphone.text.toString(),
                   etid.text.toString(),
                   etname.text.toString(),
                   etnews.text.toString(),

                   etheading.text.toString()
           )
           val bd=FirebaseDatabase.getInstance().getReference()
            val auth=FirebaseAuth.getInstance().currentUser
            if (auth != null) {
                bd.child("login").child(auth.uid).child("news").push().setValue(obj)
                Toast.makeText(this,"published", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this,"you are not signned in", Toast.LENGTH_SHORT).show()

            }
            bd.child("news").push().setValue(obj)
            etheading.setText("")
            etname.setText("")
            etid.setText("")
            etphone.setText("")
            etnews.setText("")



         }
    }
}
