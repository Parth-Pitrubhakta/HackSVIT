package com.example.hacksvit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.Adapter.ImageSS_Adapterr
import com.example.hacksvit.R
import com.example.hacksvit.data.imagedata
import com.example.hacksvit.data.ngodata


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



        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView1)
        recycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL ,false)
        recycler.adapter = ImageSS_Adapterr(data1)


    }
}