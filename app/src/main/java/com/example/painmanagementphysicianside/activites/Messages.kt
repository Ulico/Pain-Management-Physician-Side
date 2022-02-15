package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.painmanagementphysicianside.R

class Messages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
    }

    fun onHome(view: View) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}