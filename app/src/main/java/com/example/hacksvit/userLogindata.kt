package com.example.hacksvit

import com.google.firebase.database.Exclude

class userLogindata (
    var Name: String? = "",
    var Address: String? = "",
    var Email: String? = "",
    var Phone_no: String? = ""){


    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Name" to Name,
            "Address" to Address,
            "Email" to Email,
            "Phone_no" to Phone_no

            )
    }

}