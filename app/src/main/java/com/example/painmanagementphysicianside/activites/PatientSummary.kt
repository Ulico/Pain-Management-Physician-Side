package com.example.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.painmanagementphysicianside.R
import com.example.painmanagementphysicianside.databinding.ActivityPatientSummaryBinding
import com.example.painmanagementphysicianside.models.Patient
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView
import com.google.gson.Gson

class PatientSummary : AppCompatActivity() {

    private lateinit var binding: ActivityPatientSummaryBinding
    private lateinit var patientJson: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientSummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.navView.selectedItemId = R.id.navigationData

        patientJson = intent.getStringExtra("PATIENT")!!
        val pat: Patient = Gson().fromJson(patientJson, Patient::class.java)

        ("Patient: " + pat.name).also { binding.patientNameText.text = it }
        ("Age: " + pat.age).also { binding.patientAgeText.text = it }

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    startActivity(Intent(this@PatientSummary, Homescreen::class.java))
                }
                R.id.navigationProfile -> {
                    val intent = Intent(this@PatientSummary, UserProfile::class.java)
                    intent.putExtra("PATIENT", patientJson)
                    startActivity(intent)
                }
            }
            true
        }
    }
}