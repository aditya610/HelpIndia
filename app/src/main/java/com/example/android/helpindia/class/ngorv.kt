package com.example.android.helpindia.`class`

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.android.helpindia.Login.Main_Activitylogin
import com.example.android.helpindia.Main2Activity
import com.example.android.helpindia.MainActivityNgo
import com.example.android.helpindia.MainActivitypics
import com.example.android.helpindia.R
import com.google.android.gms.common.util.ArrayUtils.resize
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_pics.*

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
        Picasso.get()
                .load(list[position].url[0].url)
                .centerCrop().resize(1700,1200)
                .into(holder.image)
        Log.e("pic",list[position].url[0].url)
        holder.name1.text=list[position].name
        holder.type1.text="Type: "+list[position].type
        holder.cause.text="Cause: "+list[position].cause
        holder.city.text="City: "+ list[position].city
        val context: Context = holder.itemView.context
        holder.itemView.setOnClickListener({
           val actintent= Intent(context, MainActivityNgo::class.java)
            val text=position
            actintent.putExtra("number",list[position].name)
           context.startActivity(actintent)

            Log.e("click",position.toString())
        })
    }

    class viewholder(val view1:View):RecyclerView.ViewHolder(view1)
    {   val image=view1.findViewById<ImageView>(R.id.ivngo1)
        val name1=view1.findViewById<TextView>(R.id.tvname)
        val type1=view1.findViewById<TextView>(R.id.tvtype)
        val cause=view1.findViewById<TextView>(R.id.tvcause)
        val city=view1.findViewById<TextView>(R.id.tvcity)

    }
}