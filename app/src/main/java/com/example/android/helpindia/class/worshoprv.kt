package com.example.android.helpindia.`class`

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.helpindia.R
import kotlinx.android.synthetic.main.eventlayout.view.*
import org.w3c.dom.Text

class worshoprv(val workshop:ArrayList<Workshop>):RecyclerView.Adapter<worshoprv.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=li.inflate(R.layout.eventlayout,
                parent,
                false
        )
        return viewholder(view)
    }

    override fun getItemCount(): Int {
return workshop.size   }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
         holder.name11.text=workshop[position].name
        holder.city.text="City: "+workshop[position].city
        holder.purpose.text="Topic: "+workshop[position].purpose
        holder.timedate.text=workshop[position].timedate
        holder.reason.text="  Reason to join:\n"+workshop[position].reason

    }

    class viewholder(view:View):RecyclerView.ViewHolder(view){
        var name11=view.findViewById<TextView>(R.id.tvname)
        var purpose=view.findViewById<TextView>(R.id.tvpurpose)
        var city=view.findViewById<TextView>(R.id.tvcity)
        var timedate=view.findViewById<TextView>(R.id.tvtimedate)
        var reason=view.findViewById<TextView>(R.id.tvreason)
    }
}