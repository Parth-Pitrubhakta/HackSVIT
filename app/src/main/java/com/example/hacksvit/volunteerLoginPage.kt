package com.example.hacksvit

import android.content.ContentValues
import android.content.Intent
import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class volunteerLoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer_login_page)

        val Name= findViewById<TextInputEditText>(R.id.name)
        val Address= findViewById<TextInputEditText>(R.id.address_text)
        val Email= findViewById<TextInputEditText>(R.id.email_text)
        val Phone_no= findViewById<TextInputEditText>(R.id.Phone_no_text)

        val Submit_btn_vol = findViewById<Button>(R.id.Submit_btn_volunteer)
        Submit_btn_vol.setOnClickListener {

            updatedata(Name.text.toString(),Address.text.toString(),
                Email.text.toString(),Phone_no.text.toString()

            )
        }



    }

    private fun updatedata(Name: String, Address: String,Email:String,Phone_no: String) {

        val database = Firebase.database.reference
        val userLogindata1 = userLogindata(Name, Address, Email, Phone_no)
        val data = userLogindata1.toMap()

        val userdataupdates = hashMapOf<String, Any>("Volunteers/${Firebase.auth.uid}/" to data)
        database.updateChildren(userdataupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, MainActivity::class.java))


        }

    }
}