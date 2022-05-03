package com.example.hacksvit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class profileNgo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_ngo)

        val donors_contributors  = findViewById<ImageButton>(R.id.donors_contributors)
        donors_contributors.setOnClickListener {
            startActivity(Intent(this, ngoLoginPage::class.java))
        }
        val add_campaigns  = findViewById<ImageButton>(R.id.add_campaigns)
        add_campaigns.setOnClickListener {
            startActivity(Intent(this, addcampaigns::class.java))
        }
        val logout_ngo  = findViewById<ImageButton>(R.id.logout_ngo)
        logout_ngo.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, signInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or (Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }
}