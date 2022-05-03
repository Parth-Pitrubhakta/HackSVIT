package com.example.hacksvit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hacksvit.Adapter.donors_Adapter

class donorsOrContributorsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donors_or_contributors_page)

        val recyclerview = findViewById<RecyclerView>(R.id.donors_recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<DonorsitemsViewModel>()
//        for (i in 1..20) {
//            data.add(DonorsitemsViewModel(R.drawable.ic_baseline_folder_24, "Item " + i))
//        }

        val adapter = donors_Adapter(data)
        recyclerview.adapter = adapter
    }
}