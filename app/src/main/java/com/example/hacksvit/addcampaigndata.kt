package com.example.hacksvit

import com.google.firebase.database.Exclude

class addcampaigndata(
    var Campaign_name: String? = "",
    var Campaign_cat: String? = "",
    var Time_period: String? = "",
    var Venue: String? = "",
)
{

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Campaign_Name" to Campaign_name,
            "Campaign_category" to Campaign_cat,
            "Time_period" to Time_period,
            "Venue" to Venue
        )
    }
}