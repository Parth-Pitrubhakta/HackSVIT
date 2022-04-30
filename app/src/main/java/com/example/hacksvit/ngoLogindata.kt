package com.example.hacksvit

import com.google.firebase.database.Exclude

class ngoLogindata (

    var Name_ngo: String? = "",
    var Address_ngo: String? = "",
    var Email_ngo: String? = "",
    var Phone_no_ngo: String? = ""){


    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Name" to Name_ngo,
            "Address" to Address_ngo,
            "Email" to Email_ngo,
            "Phone_no" to Phone_no_ngo

        )
    }

}