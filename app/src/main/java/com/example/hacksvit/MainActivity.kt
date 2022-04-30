package com.example.hacksvit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hacksvit.R.id.bottom_navigation
import com.example.hacksvit.fragments.Dashboard
import com.example.hacksvit.fragments.MyAccount
import com.example.hacksvit.fragments.Nearby_NGO

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private val dashboard= Dashboard()
    private val nearby= Nearby_NGO()
    private val my_acc= MyAccount()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom_navigation=findViewById<BottomNavigationView>(bottom_navigation)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.page_1 ->replaceFragment(dashboard)
                R.id.page_2 ->replaceFragment(nearby)
                R.id.page_3 ->replaceFragment(my_acc)
            }
            true
        }





        replaceFragment(dashboard)
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }


    }
}