package com.example.hacksvit

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class edit_Profile_Ngo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_ngo)

        val name_edit = findViewById<EditText>(R.id.name_vol_edit)
        val email_edit = findViewById<EditText>(R.id.email_vol_edit)
        val address_edit = findViewById<EditText>(R.id.address_vol_edit)
        val phone_no_edit = findViewById<EditText>(R.id.phone_vol_edit)

        val save_btn = findViewById<ImageButton>(R.id.editprofile_vol)
        save_btn.setOnClickListener {

            updatedata(
                name_edit.text.toString(), email_edit.text.toString(),
                address_edit.text.toString(),phone_no_edit.text.toString()

            )

        }

        val database = Firebase.database.getReference("NGO/${Firebase.auth.uid}")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                name_edit.setText(snapshot.child("Name").value.toString())
                address_edit.setText(snapshot.child("Address").value.toString())
                email_edit.setText(snapshot.child("Email").value.toString())
                phone_no_edit.setText(snapshot.child("Phone_no").value.toString())

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })
    }

    private fun updatedata(
        name_edit: String,
        address_edit: String,
        email_edit: String,
        phone_no_edit: String
    ) {

        val database = Firebase.database.reference
        val editprofiledata_ngo = edit_profile_data_ngo(name_edit, address_edit, email_edit, phone_no_edit)
        val data = editprofiledata_ngo.toMap()
        val editprofiledata_ngo_updates = hashMapOf<String, Any>("NGO/${Firebase.auth.uid}" to data)
        database.updateChildren(editprofiledata_ngo_updates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, ngoLoginPage::class.java))

        }
    }
}
