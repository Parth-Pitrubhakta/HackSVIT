package com.example.hacksvit.Adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.R
import com.example.hacksvit.DonorsitemsViewModel
import com.example.hacksvit.paymentIntergation

class donors_Adapter(var data: List<DonorsitemsViewModel>) : RecyclerView.Adapter<donors_Adapter.IntViewHolder>() {

    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row)  {
        val nameView = row.findViewById<TextView>(R.id.text_name_donors)
        val categoryView = row.findViewById<TextView>(R.id.text_category_donor)
        val donatiosnView = row.findViewById<TextView>(R.id.text_donations_donors)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design,parent, false)
        val holder= donors_Adapter.IntViewHolder(layout)

        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {

        val item=data[position]
        holder.nameView.text = item.textname.toString()
        holder.categoryView.text = item.textcategory.toString()
        holder.donatiosnView.text = item.textdonations.toString()

    }

    override fun getItemCount(): Int {
        return data.size
    }
}