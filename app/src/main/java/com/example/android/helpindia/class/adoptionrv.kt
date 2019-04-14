package com.example.android.helpindia.`class`

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.android.helpindia.MainActivityNgo
import com.example.android.helpindia.R
import com.google.android.gms.dynamite.DynamiteModule
import com.squareup.picasso.Picasso

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
        Picasso.get()
                .load(adoption[position].url2[0].url)
                .centerCrop().resize(1700,1200)
                .into(holder.image)
        holder.name1.text=adoption[position].name
        holder.type1.text="type :"+adoption[position].type
        //holder.cause.text=list[position].cause
        holder.city.text="city: "+adoption[position].city

        val context: Context = holder.itemView.context
        holder.itemView.setOnClickListener({
            val actintent= Intent(context, MainActivityNgo::class.java)
            val text=position
            actintent.putExtra("numbe",adoption[position].name)
            context.startActivity(actintent)

            Log.e("click",position.toString())
        })
    }

    class viewholder(val view:View):RecyclerView.ViewHolder(view)
    {  val image=view.findViewById<ImageView>(R.id.ivngo)
        val name1=view.findViewById<TextView>(R.id.tvname)
        val type1=view.findViewById<TextView>(R.id.tvtype)
       // val cause=view.findViewById<TextView>(R.id.tvcause)
        val city=view.findViewById<TextView>(R.id.tvcity)

    }
}