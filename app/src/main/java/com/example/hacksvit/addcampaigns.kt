package com.example.hacksvit

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class addcampaigns : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcampaigns)

        val campaign_name = findViewById<EditText>(R.id.Campaign_name)
        val campaign_cat = findViewById<EditText>(R.id.Campaign_cat)
        val time_period = findViewById<EditText>(R.id.time_period)
        val venue = findViewById<EditText>(R.id.venue)

        val post_campaign = findViewById<ImageButton>(R.id.post_campaign)
        post_campaign.setOnClickListener {

            userupdates(campaign_name.text.toString(),campaign_cat.text.toString(),time_period.text.toString(),venue.text.toString())
        }
    }

    private fun userupdates(campaign_name: String, campaign_cat: String, time_period: String, venue: String) {

        val database = Firebase.database.reference
        val addcampaign1 = addcampaigndata(campaign_name, campaign_cat, time_period, venue)
        val data = addcampaign1.toMap()
        val key = database.child("NGO").push().key
        val addcampaign_updates = hashMapOf<String, Any>("NGO/${Firebase.auth.uid}/Campaign/$key" to data)
        database.updateChildren(addcampaign_updates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, profileNgo::class.java))

        }
    }
}