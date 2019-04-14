package com.example.android.helpindia

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.helpindia.`class`.pics
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_pics.*

class MainActivitypics : AppCompatActivity() {
 val Gallery_intent=2
    lateinit var storage: StorageReference
    lateinit var mstorage:DatabaseReference
    lateinit var url:ArrayList<pics>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pics)
     storage = FirebaseStorage.getInstance().getReference()
        mstorage= FirebaseDatabase.getInstance().getReference()

        upload.setOnClickListener({
            val intent=Intent(Intent.ACTION_PICK)
            intent.setType("image/=")
            startActivityForResult(intent,Gallery_intent)
        })
        btnshow.setOnClickListener({
            mstorage.child("photos").addValueEventListener(object :ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val children: MutableIterable<DataSnapshot> = p0.children
                    for (child in children){
                        val value: String? = child.getValue(String::class.java)

                        Picasso.get()
                                .load(value)
                                .resize(600, 300)
                                .centerCrop()
                                .into(ivimg)
                    }
                    }

            })
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    if(requestCode==Gallery_intent){
        if (data != null) {
            val data1: Uri = data.data
            val child: StorageReference = storage.child("photos").child(data1.lastPathSegment)
            child.putFile(data1).addOnSuccessListener( {taskSnapshot->

                    Toast.makeText(this@MainActivitypics,"Upload done",Toast.LENGTH_SHORT).show()
                    taskSnapshot.storage.downloadUrl.addOnSuccessListener {
                        val result=it.toString()
                        mstorage.child("photos").push().setValue(result)

                    }



             })
        }
    }
    }
}
