package com.example.android.helpindia.`class`

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android.helpindia.R
import com.squareup.picasso.Picasso

class ngomainrv(val list: ArrayList<pics>):RecyclerView.Adapter<ngomainrv.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
val view=    li.inflate(
            R.layout.imagelayout
                    ,parent,
            false
    )
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        Picasso.get()
                .load(list[position].url)
                .centerCrop().resize(1700,1200)
                .into(holder.image)
    }

    class viewholder(val view:View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.ivimage)
    }
}