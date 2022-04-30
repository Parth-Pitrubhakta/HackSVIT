package com.example.hacksvit.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.Adapter.ImageSS_Adapterr
import com.example.hacksvit.R
import com.example.hacksvit.data.imagedata
import com.example.hacksvit.data.ngodata
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot



class Dashboard : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data1= arrayListOf<imagedata>()
        val data2= arrayListOf<ngodata>()

        data1.add(imagedata(R.drawable.image1))
        data1.add(imagedata(R.drawable.image2))


        val database = FirebaseDatabase.getInstance().getReference("NGO/${Firebase.auth.uid}/Campaign")
         val ngodata = arrayListOf<ngodata>()

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                for (i in p0.children) {

                    val compdat = i.getValue<ngodata>()

                    compdat?.let { ngodata.add(it) }
                    Log.e(ContentValues.TAG,"user info" +compdat)


                }




        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView1)
        recycler.layoutManager = GridLayoutManager(view.context, 2)
        recycler.adapter = ImageSS_Adapterr(data1)


             }
        })
    }
}
