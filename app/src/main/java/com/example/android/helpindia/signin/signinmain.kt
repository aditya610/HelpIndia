package com.example.android.helpindia.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.android.helpindia.R
import com.example.android.helpindia.R.id.btnind
import com.example.android.helpindia.R.id.btnngo
import com.example.android.helpindia.`class`.list
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import kotlinx.android.synthetic.main.activity_signinmain.*
import java.util.*
import kotlin.collections.ArrayList

class signinmain : AppCompatActivity() {
    val RC_SIGN_IN=1000
     var userid=""
    var list=ArrayList<String>()
    var flag=0
    var run=0
    val firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signinmain)
       list.clear()
        val db=FirebaseDatabase.getInstance().getReference()
        if (firebaseUser != null) {
        btnngo.setOnClickListener({
        db.child("userid").addValueEventListener(object :ValueEventListener{

            override fun onCancelled(p0: DatabaseError) {
                val intent = Intent(
                        this@signinmain,
                        NGOsignin::class.java
                )
                startActivity(intent)
            }

            override fun onDataChange(p0: DataSnapshot) {
                list.clear()
                run=1
                flag=0
                val children = p0.children
                for(child in children) {
                    val value: String? = child.getValue(String::class.java)
                    if (value != null) {
                        list.add(value)
                    }
                }
                    for (i in list) {
                        if (firebaseUser != null) {
                            Log.d("listzz",i)
                            Log.d("useridzz",firebaseUser.uid)
                            if (i == firebaseUser.uid) {
                                flag=1;}}}

                                    if (flag == 0) {

                                        val intent = Intent(
                                                this@signinmain,
                                                NGOsignin::class.java
                                        )
                                        startActivity(intent)

                                    }
                                    else{
                                        Toast.makeText(this@signinmain,"you are logged in",Toast.LENGTH_SHORT).show()
                                    }

                                           }


        })
        })



                btnind.setOnClickListener({
                    db.child("userid").addValueEventListener(object :ValueEventListener{

                        override fun onCancelled(p0: DatabaseError) {
                            val intent = Intent(
                                    this@signinmain,
                                    NGOsignin::class.java
                            )
                            startActivity(intent)
                        }

                        override fun onDataChange(p0: DataSnapshot) {
                            list.clear()
                            run=1
                            flag=0
                            val children = p0.children
                            for(child in children) {
                                val value: String? = child.getValue(String::class.java)
                                if (value != null) {
                                    list.add(value)
                                }
                            }
                                for (i in list) {
                                    if (firebaseUser != null) {
                                        Log.d("listzz",i)
                                        Log.d("useridzz",firebaseUser.uid)

                                        Log.d("flagzz",flag.toString())
                                        if (i == firebaseUser.uid) {
                                            flag=1;}}}
                                            if(flag==0) {
                                                val intent = Intent(
                                                        this@signinmain,
                                                        indvisignin::class.java
                                                )
                                                startActivity(intent)
                                            }
                            else{
                                                Toast.makeText(this@signinmain,"you are logged in",Toast.LENGTH_SHORT).show()
                                            }

                                             }


                    })
                })



        }
        else{
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setAvailableProviders(Arrays.asList(
                                    AuthUI.IdpConfig.GoogleBuilder().build(),
                                    AuthUI.IdpConfig.EmailBuilder().build(),
                                    AuthUI.IdpConfig.PhoneBuilder().build()))
                            .build(),
                    RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    if(requestCode==RC_SIGN_IN)
    {
        val firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        val response = IdpResponse.fromResultIntent(data)

        // Successfully signed in
        if (resultCode == Activity.RESULT_OK) {
            setContentView(R.layout.activity_signinmain)
            val db=FirebaseDatabase.getInstance().getReference()
            btnngo.setOnClickListener({
                db.child("userid").addValueEventListener(object :ValueEventListener{

                    override fun onCancelled(p0: DatabaseError) {
                        val intent = Intent(
                                this@signinmain,
                                NGOsignin::class.java
                        )
                        startActivity(intent)
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        list.clear()
                        run=1
                        flag=0
                        val children = p0.children
                        for(child in children){
                            val value: String? = child.getValue(String::class.java)
                            if (value != null) {
                                list.add(value)
                            }}
                            for (i in list) {
                                if (firebaseUser != null) {
                                    Log.d("listzz",i)
                                    Log.d("useridzz",firebaseUser.uid)
                                    if (i == firebaseUser.uid) {
                                        flag=1;}}}
                                        if (flag==0) {
                                            if (firebaseUser != null) {
                                                val intent = Intent(
                                                        this@signinmain,
                                                        NGOsignin::class.java
                                                )
                                                startActivity(intent)
                                            }
                                        }
                                        else{
                                            Toast.makeText(this@signinmain,"you are logged in",Toast.LENGTH_SHORT).show()
                                        }

                    }

                })
            })


            btnind.setOnClickListener({
                db.child("userid").addValueEventListener(object :ValueEventListener{

                    override fun onCancelled(p0: DatabaseError) {
                        val intent = Intent(
                                this@signinmain,
                                NGOsignin::class.java
                        )
                        startActivity(intent)
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        list.clear()
                        run=1
                        flag=0
                        val children = p0.children
                        for(child in children) {
                            val value: String? = child.getValue(String::class.java)
                            if (value != null) {
                                list.add(value)
                            }
                        }
                            for (i in list) {
                                if (firebaseUser != null) {
                                    Log.d("listzz", i)
                                    Log.d("useridzz", firebaseUser.uid)
                                    if (i == firebaseUser.uid) {
                                        flag = 1;
                                    }
                                }
                            }
                        Log.d("flagzz",flag.toString())
                                        if (flag==0) {
                                                val intent = Intent(
                                                        this@signinmain,
                                                        indvisignin::class.java
                                                )
                                                startActivity(intent)
                                            }
                                        else{
                                            Toast.makeText(this@signinmain,"you are logged in",Toast.LENGTH_SHORT).show()
                                        }



                    }

                })
            })



        }
    }
    }

}
