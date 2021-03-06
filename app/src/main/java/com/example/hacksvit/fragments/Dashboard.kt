package com.example.hacksvit.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.Adapter.ImageSS_Adapterr
import com.example.hacksvit.Adapter.NgoList_Adapter
import com.example.hacksvit.R
import com.example.hacksvit.data.imagedata
import com.example.hacksvit.data.ngodata
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Dashboard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vol_name = view.findViewById<TextView>(R.id.vol_name)
//        val text_ngo_name = view.findViewById<TextView>(R.id.text_ngo_name)
//        val text_campaign_name = view.findViewById<TextView>(R.id.text_campaign_name)
        val data1 = arrayListOf<imagedata>()


        data1.add(imagedata(R.drawable.image1))
        data1.add(imagedata(R.drawable.image2))

       val database = FirebaseDatabase.getInstance().getReference("NGO/Campaign")
        val ngoData = arrayListOf<ngodata>()

        database.addListenerForSingleValueEvent(object : ValueEventListener {
           override fun onCancelled(p0: DatabaseError) {

            }

           override fun onDataChange(p0: DataSnapshot) {
               for (i in p0.children) {

                    val ngodat = i.getValue<ngodata>()

                   ngodat?.let { ngoData.add(it) }
                   Log.e(ContentValues.TAG, "user info$ngodat")
               }
        val recycler1 = view.findViewById<RecyclerView>(R.id.recyclerView1)
        recycler1.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, true)
        recycler1.adapter = ImageSS_Adapterr(data1)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView2)
        recycler.layoutManager = GridLayoutManager(view.context, 2)
        recycler.adapter = NgoList_Adapter(ngoData)

         }

        })

        val database2 = Firebase.database.getReference("Volunteers/${Firebase.auth.uid}")
        database2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                vol_name.setText(snapshot.child("Name").value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })

    }
}
