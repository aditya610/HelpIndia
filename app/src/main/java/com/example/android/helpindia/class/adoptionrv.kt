package com.example.android.helpindia.`class`

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.helpindia.R

class adoptionrv(val adoption:ArrayList<Adoption>) :RecyclerView.Adapter<adoptionrv.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=li.inflate(
                R.layout.adoptionlayout,
                parent,false

        )
       return  viewholder(view)
    }

    override fun getItemCount(): Int {
      return adoption.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.name1.text=adoption[position].name
        holder.type1.text=adoption[position].type
        //holder.cause.text=list[position].cause
        holder.city.text=adoption[position].city
    }

    class viewholder(val view:View):RecyclerView.ViewHolder(view)
    {
        val name1=view.findViewById<TextView>(R.id.tvname)
        val type1=view.findViewById<TextView>(R.id.tvtype)
       // val cause=view.findViewById<TextView>(R.id.tvcause)
        val city=view.findViewById<TextView>(R.id.tvcity)

    }
}