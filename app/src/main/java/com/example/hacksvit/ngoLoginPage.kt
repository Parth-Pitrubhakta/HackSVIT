package com.example.hacksvit

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ngoLoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ngo_login_page)


        val Name_ngo= findViewById<TextInputEditText>(R.id.name_ngo)
        val Address_ngo= findViewById<TextInputEditText>(R.id.address_ngo)
        val Email_ngo= findViewById<TextInputEditText>(R.id.Email_ngo)
        val Phone_no_ngo= findViewById<TextInputEditText>(R.id.Pnone_no_ngo)

        val Submit_btn_ngo = findViewById<Button>(R.id.Submit_btn_ngo)
        Submit_btn_ngo.setOnClickListener {

            updatedata(Name_ngo.text.toString(),Address_ngo.text.toString(),
                Email_ngo.text.toString(),Phone_no_ngo.text.toString()

            )
        }

    }

    private fun updatedata(Name_ngo: String, Address_ngo: String, Email_ngo: String, Phone_no_ngo: String) {

        val database = Firebase.database.reference
        val ngoLoginPage1 = userLogindata(Name_ngo, Address_ngo, Email_ngo, Phone_no_ngo)
        val data = ngoLoginPage1.toMap()

        val ngologinupdates = hashMapOf<String, Any>("NGO/${Firebase.auth.uid}/" to data)
        database.updateChildren(ngologinupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, MainActivity::class.java))
      }

    }
}