package com.example.android.helpindia.`class`

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.helpindia.R
import kotlinx.android.synthetic.main.secondhalf_main.view.*

class newsrv(val new1:ArrayList<News>
             ):RecyclerView.Adapter<newsrv.viewholder>()
{/*    override fun getItemViewType(position: Int): Int {
    return when (position) {
                    0 -> 0
                    else -> 1
              }
*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
       val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view=li.inflate(R.layout.secondhalf_main,
               parent,
               false
       )
       return viewholder(view)
    }


    override fun getItemCount(): Int {
       return new1.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

    holder.new1.text = new1[position].new1
    holder.heading.text = new1[position].heading
       /* holder.itemView.setOnLongClickListener({
            AlertDialog.Builder(holder.itemView.context)
                    .setTitle("delete news")
                    .setMessage("do yo really want to delete this news")
                    .setPositiveButton("yes",
                            {_,_->
                                ontaskdelete(new1[position])
                            }).setNegativeButton("no",{
                        _,_->Unit
                    }).show()
            true
        })*/
   }

    class viewholder(val itemview:View):RecyclerView.ViewHolder(itemview)
    {
        val new1=itemview.findViewById<TextView>(R.id.tvnews)
        val heading=itemview.findViewById<TextView>(R.id.tvheading)
    }
}