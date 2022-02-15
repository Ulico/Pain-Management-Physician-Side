package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.painmanagementphysicianside.R

class PatientSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_summary)
    }

    fun onHome(item: MenuItem) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}