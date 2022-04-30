package com.example.hacksvit.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.R
import com.example.hacksvit.donors_itemsViewModel

class donors_Adapter(private val mList: List<donors_itemsViewModel>) : RecyclerView.Adapter<donors_Adapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return RecyclerView.ViewHolder(view)
    }

}