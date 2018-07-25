package com.example.android.helpindia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.android.helpindia.`class`.Adoption
import com.example.android.helpindia.`class`.adoptionrv
import com.example.android.helpindia.`class`.generaterandomadoption
import kotlinx.android.synthetic.main.adoption_main.*

var adoption=ArrayList<Adoption>()
class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adoption_main)
        adoption= generaterandomadoption()
        val adapter=adoptionrv(adoption)
        rvadoption.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rvadoption.adapter=adapter
    }
}
