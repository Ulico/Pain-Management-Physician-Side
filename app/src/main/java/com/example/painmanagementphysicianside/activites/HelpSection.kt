package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.painmanagementphysicianside.R

class HelpSection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_section)
    }

    fun onReturnToLoginPage(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}