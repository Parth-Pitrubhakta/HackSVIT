package com.example.hacksvit.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.R
import com.example.hacksvit.data.imagedata
import com.example.hacksvit.data.ngodata
import com.example.hacksvit.paymentIntergation

class NgoList_Adapter(var data: List<ngodata>) : RecyclerView.Adapter<NgoList_Adapter.IntViewHolder>()  {
    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row)  {
        val textView1 = row.findViewById<TextView>(R.id.textView1)
        val textView2 = row.findViewById<TextView>(R.id.textView2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard2,parent,false)
        val holder= NgoList_Adapter.IntViewHolder(layout)
        layout.setOnClickListener {
            val intent = Intent(parent.context, paymentIntergation::class.java)
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {

        val item=data[position]
        holder.textView1.text=item.ngoname.toString()
        holder.textView2.text=item.category.toString()

    }

    override fun getItemCount(): Int {
        return data.size
    }
}