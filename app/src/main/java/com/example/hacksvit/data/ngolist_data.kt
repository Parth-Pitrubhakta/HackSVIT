package com.example.hacksvit.data

import com.google.firebase.database.Exclude

data class ngodata( val ngoname:String,
                    val category:String)
{

    constructor():this("","")
    @Exclude

    fun toMap():Map<String,Any?> {

        return mapOf(
            "Campaign_Name" to ngoname,
            "Campaign_category" to category
        )
    }

}