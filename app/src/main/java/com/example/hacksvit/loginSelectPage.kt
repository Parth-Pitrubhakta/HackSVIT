package com.example.hacksvit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class loginSelectPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_select_page)

        var btnVolunteerLogin = findViewById<View>(R.id.btn_volunteerLogin)
        var btnNgoLogin = findViewById<View>(R.id.btn_ngoLogin)

        btnVolunteerLogin.setOnClickListener{
            val intent = Intent(this, volunteerLoginPage::class.java)
            startActivity(intent)
        }

        btnNgoLogin.setOnClickListener {
            val intent = Intent(this, ngoLoginPage::class.java)
            startActivity(intent)
        }

    }
}