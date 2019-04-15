package com.example.android.helpindia.Login

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.android.helpindia.R
import com.example.android.helpindia.`class`.signinclass
import com.example.android.helpindia.`class`.signinclass2
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main__activitylogin.*
import java.util.*

class Main_Activitylogin : AppCompatActivity() {
val RC_SIGN_IN=123
var flag=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db=FirebaseDatabase.getInstance().getReference()
        val auth= FirebaseAuth.getInstance().currentUser
        if (auth != null) {
            setContentView(R.layout.activity_main__activitylogin)
            loginNgo.setOnClickListener({
                if (auth != null) {
                    db.child("login").child(auth.uid).child("ngo").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onDataChange(p0: DataSnapshot) {
                            flag = 0
                            val children = p0.children
                            for (child in children) {
                                val value = child.getValue(signinclass2::class.java)
                                if (value != null) {
                                    flag = 1
                                }
                            }
                            if (flag == 1) {
                                val intent = Intent(this@Main_Activitylogin, Loginngo::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this@Main_Activitylogin,"Wrong Choice", Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                }
            })
            loginindi.setOnClickListener({
                if (auth != null) {
                    db.child("login").child(auth.uid).child("individual").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onDataChange(p0: DataSnapshot) {
                            flag = 0
                            val children = p0.children
                            for (child in children) {
                                val value = child.getValue(signinclass::class.java)
                                if (value != null) {
                                    flag = 1
                                }
                            }
                            if (flag == 1) {
                                val intent = Intent(this@Main_Activitylogin, Loginindividual::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this@Main_Activitylogin,"Wrong Choice", Toast.LENGTH_SHORT).show()
                            }
                        }})
                        }

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
       /* if (auth != null) {
            Log.e("check","passauth")
            Log.e("check",db.child("login").child(auth.uid).child("individual").toString())
            if(db.child("login").child(auth.uid).child("individual").toString()!="null") {
                Log.e("check","pass")
                val intent= Intent(this,Loginindividual::class.java)
                startActivity(intent)
            }
        }*/


}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    if (requestCode==RC_SIGN_IN)
    {
        if(resultCode==Activity.RESULT_OK)
        {setContentView(R.layout.activity_main__activitylogin)
            val db=FirebaseDatabase.getInstance().getReference()
            val auth= FirebaseAuth.getInstance().currentUser
            loginNgo.setOnClickListener({
                if (auth != null) {
                    db.child("login").child(auth.uid).child("ngo").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onDataChange(p0: DataSnapshot) {
                            flag = 0
                            val children = p0.children
                            for (child in children) {
                                val value = child.getValue(signinclass2::class.java)
                                if (value != null) {
                                    flag = 1
                                }
                            }
                            if (flag == 1) {
                                val intent = Intent(this@Main_Activitylogin, Loginngo::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this@Main_Activitylogin,"Wrong Choice", Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                }
            })
            loginindi.setOnClickListener({
                if (auth != null) {
                    db.child("login").child(auth.uid).child("individual").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onDataChange(p0: DataSnapshot) {
                            flag = 0
                            val children = p0.children
                            for (child in children) {
                                val value = child.getValue(signinclass::class.java)
                                if (value != null) {
                                    flag = 1
                                }
                            }
                            if (flag == 1) {
                                val intent = Intent(this@Main_Activitylogin, Loginindividual::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this@Main_Activitylogin,"Wrong Choice", Toast.LENGTH_SHORT).show()
                            }
                        }})
                }
            })

        }
    }
    }
}
