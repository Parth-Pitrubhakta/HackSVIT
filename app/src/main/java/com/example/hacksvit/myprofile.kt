package com.example.hacksvit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class myprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myprofile)

        var btneditprofile = findViewById<View>(R.id.edit_text)
        btneditprofile.setOnClickListener {
            val intent = Intent(this, editprofile::class.java)
            startActivity(intent)
        }
    }
}