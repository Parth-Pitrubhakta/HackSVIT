package com.example.hacksvit

import com.google.firebase.database.Exclude

class edit_profile_data_ngo(

    var name_edit: String? = "",
    var address_edit: String? = "",
    var email_edit: String? = "",
    var phone_no_edit: String? = ""
) {


    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Name" to name_edit,
            "Email" to email_edit,
            "Address" to address_edit,
            "Phone_no" to phone_no_edit)
    }
}