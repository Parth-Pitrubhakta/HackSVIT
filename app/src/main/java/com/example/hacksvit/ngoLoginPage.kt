package com.example.hacksvit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

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

    private fun updatedata(e: String, toString: String, toString1: String, toString2: String) {

    }
}