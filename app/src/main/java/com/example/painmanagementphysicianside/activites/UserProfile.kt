package com.example.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.painmanagementphysicianside.R
import com.example.painmanagementphysicianside.databinding.ActivityUserProfileBinding
import com.example.painmanagementphysicianside.models.Patient
import com.google.gson.Gson

class UserProfile : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var patientJson: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.navView.selectedItemId = R.id.navigationData

        patientJson = intent.getStringExtra("PATIENT")!!
        val pat: Patient = Gson().fromJson(patientJson, Patient::class.java)
        ("Full Patient Name: " + pat.name).also { binding.fullPatientNameText.text = it }

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    startActivity(Intent(this@UserProfile, Homescreen::class.java))
                }
                R.id.navigationProfile -> {
                    val intent = Intent(this@UserProfile, PatientSummary::class.java)
                    intent.putExtra("PATIENT", patientJson)
                    startActivity(intent)
                }
            }
            true
        }
    }


}