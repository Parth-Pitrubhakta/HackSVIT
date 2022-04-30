package com.example.hacksvit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.R
import com.example.hacksvit.data.imagedata

class ImageSS_Adapterr(var imagess_data: List<imagedata>) : RecyclerView.Adapter<ImageSS_Adapterr.IntViewHolder>()  {
    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row)  {
        val imageView = row.findViewById<ImageView>(R.id.itemImage)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard,parent,false)
        val holder= IntViewHolder(layout)
        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item=imagess_data[position]
        holder.imageView.setBackgroundResource(item.img)
    }

    override fun getItemCount(): Int {
          return imagess_data.size

    }
}