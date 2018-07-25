package com.example.android.helpindia.`class`

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.helpindia.R

class ngorv(val list:ArrayList<Ngo>):RecyclerView.Adapter<ngorv.viewholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
     //  val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=li.inflate(R.layout.ngolayout_main,
                parent,
                false
        )
       // val view=li.inflate(R.layout.ngolayout_main,parent,false)
return viewholder(view)
            }

    override fun getItemCount(): Int {
return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.name1.text=list[position].name
        holder.type1.text=list[position].type
        holder.cause.text=list[position].cause
        holder.city.text=list[position].city
    }

    class viewholder(val view1:View):RecyclerView.ViewHolder(view1)
    {
        val name1=view1.findViewById<TextView>(R.id.tvname)
        val type1=view1.findViewById<TextView>(R.id.tvtype)
        val cause=view1.findViewById<TextView>(R.id.tvcause)
        val city=view1.findViewById<TextView>(R.id.tvcity)

    }
}