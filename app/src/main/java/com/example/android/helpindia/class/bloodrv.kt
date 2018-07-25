package com.example.android.helpindia.`class`

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.helpindia.R

class bloodrv(val blood:ArrayList<Blood>):RecyclerView.Adapter<bloodrv.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        val view=li.inflate(
                R.layout.bloodlayout,
                parent,
                false
        )
        return viewholder(view)
           }

    override fun getItemCount(): Int {
return blood.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.cname.text=blood[position].campname
        holder.pname.text=blood[position].place
        holder.dname.text=blood[position].date
        holder.tname.text=blood[position].time

    }

    class viewholder(view:View):RecyclerView.ViewHolder(view)
    {
       var cname=view.findViewById<TextView>(R.id.tvcampname)
        var pname=view.findViewById<TextView>(R.id.tvplace)
        var dname=view.findViewById<TextView>(R.id.tvdate)
        var tname=view.findViewById<TextView>(R.id.tvtime)
    }
}