package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helpindia.`class`.News
import com.example.android.helpindia.`class`.newname
import com.example.android.helpindia.database.DBnews
import com.example.android.helpindia.database.newstable
import kotlinx.android.synthetic.main.activity_main_donation.*
import kotlinx.android.synthetic.main.activity_main_share_news.*

class MainActivityShareNews : AppCompatActivity() {
    lateinit var new1:News
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_share_news)
        val db= DBnews(this).writableDatabase
        btnpublish.setOnClickListener {
            new1=News( Integer.valueOf(etphone.text.toString()),etheading.text.toString(),etnews.text.toString())
             newstable.addTask(db,new1)
            etheading.setText("")
            etname.setText("")
            etid.setText("")
            etphone.setText("")
            etnews.setText("")




         }
    }
}
