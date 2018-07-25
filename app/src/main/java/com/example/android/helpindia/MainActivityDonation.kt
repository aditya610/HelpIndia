package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_donation.*

class MainActivityDonation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_donation)
       // val empty:Editable=
        btnproceed.setOnClickListener({
            editText.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            Toast.makeText(this,"under construction",Toast.LENGTH_SHORT).show()
        })
    }
}
