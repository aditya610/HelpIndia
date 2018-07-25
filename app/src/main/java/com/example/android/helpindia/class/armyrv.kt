package com.example.android.helpindia.`class`

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.helpindia.R

class armyrv(val army:ArrayList<Army>):RecyclerView.Adapter<armyrv.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
      val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=li.inflate(
                R.layout.armylayout,
                parent,false
        )
        return viewholder(view)
          }

    override fun getItemCount(): Int {
      return army.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
       holder.heading.text=army[position].heading
        holder.news.text=army[position].new1
    }

    class viewholder(view: View):RecyclerView.ViewHolder(view)
    {
        val heading=view.findViewById<TextView>(R.id.tvheading)
        val news=view.findViewById<TextView>(R.id.tvnews)

    }
}