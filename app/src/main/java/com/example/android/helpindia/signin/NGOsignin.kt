package com.example.android.helpindia.signin

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Gallery
import android.widget.Toast
import com.example.android.helpindia.Login.Main_Activitylogin
import com.example.android.helpindia.MainActivity
import com.example.android.helpindia.R
import com.example.android.helpindia.R.id.*
import com.example.android.helpindia.`class`.Adoption
import com.example.android.helpindia.`class`.Ngo
import com.example.android.helpindia.`class`.pics
import com.example.android.helpindia.`class`.signinclass2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_ngosignin.*

class NGOsignin : AppCompatActivity() {
   lateinit var storage:StorageReference
    val Gallery_intent=2
    var url=ArrayList<pics>()
    var flag=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ngosignin)
        flag=0
    storage= FirebaseStorage.getInstance().getReference()
        btnaddphotos.setOnClickListener({
            val intent=Intent(Intent.ACTION_PICK)
            intent.setType("image/=")
            startActivityForResult(intent,Gallery_intent)

        })
        btnsignin.setOnClickListener({
            if(flag==1)
            {
            val obj = signinclass2(
                    etsignemailid.text.toString(),
                    etsignname.text.toString(),
                    etsignpasscode.text.toString(),
                    etsignngo.text.toString(),
                    etsigncity.text.toString(),
                    ettype.text.toString(),
                    etsigncause.text.toString(),
                    etsignurl.text.toString()            )
            val objngo=Ngo(url,
                    etsignngo.text.toString(),
                    ettype.text.toString(),
                    etsigncause.text.toString(),
                    etsigncity.text.toString(),
                    etsignemailid.text.toString(),
                    etsignname.text.toString(),
                    etsignurl.text.toString()
            )
            val objadoption=Adoption(url,
                    etsignngo.text.toString(),
                    ettype.text.toString(),
                    etsigncity.text.toString(),
                    etsignemailid.text.toString(),
                    etsignname.text.toString(),
                    etsignurl.text.toString())
            val db = FirebaseDatabase.getInstance().getReference()
            if (rbngo.isChecked)
                db.child("ngo").push().setValue(objngo)
            if (rbadop.isChecked)
                db.child("adoption").push().setValue(objadoption)
            val userid = FirebaseAuth.getInstance().currentUser
            if (userid != null) {
                db.child("userid").push().setValue(userid.uid)
                db.child("login").child(userid.uid).child("ngo").push().setValue(obj)
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
                else{
            Toast.makeText(this,"photos are not uploaded", Toast.LENGTH_SHORT).show()

        }})


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==Gallery_intent)
        {   val progressdial=ProgressDialog(this)
            progressdial.setTitle("uploading")
            if (data != null) {
                var data1: Uri = data.data
                val cropIntent= Intent("com.android.camera.action.CROP")
                cropIntent.setDataAndType(data1, "image/");

                cropIntent.putExtra("crop", true);

                cropIntent.putExtra("aspectX", 1);
                cropIntent.putExtra("aspectY", 1);

                cropIntent.putExtra("outputX", 128);
                cropIntent.putExtra("outputY", 128);

                cropIntent.putExtra("return-data", true);
                val extras: Bundle = cropIntent.extras
               //data1= extras.getBundle("return-data") as Uri
                val child: StorageReference = storage.child("photos").child(data1.lastPathSegment)
                progressdial.show()
                child.putFile(data1).addOnSuccessListener ( { taskspanshot->
                    progressdial.dismiss()

                    // start the activity - we handle returning in onActivityResult
                    flag=1
                    Toast.makeText(this,"uploaded",Toast.LENGTH_SHORT).show()
                    taskspanshot.storage.downloadUrl.addOnSuccessListener {
                        val result=it.toString()
                        url.add(pics(result))
                    }
                } )

            }
            else{
                Toast.makeText(this,"file not found",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
