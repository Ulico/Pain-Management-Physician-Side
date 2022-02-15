package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.painmanagementphysicianside.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLogIn(view: View) {
        val intent = Intent(this, TwoFactorAuthentication::class.java)
        startActivity(intent)
    }

    fun onHelp(view: View) {
        val intent = Intent(this, HelpSection::class.java)
        startActivity(intent)
    }
}