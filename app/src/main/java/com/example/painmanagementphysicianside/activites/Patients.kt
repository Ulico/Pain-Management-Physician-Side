package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.painmanagementphysicianside.R

class Patients : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patients)
    }

    fun onHome(view: View) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}