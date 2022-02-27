package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adrianrusso.painmanagementphysicianside.R
import com.adrianrusso.painmanagementphysicianside.databinding.ActivityUserProfileBinding
import com.adrianrusso.painmanagementphysicianside.models.Patient
import com.google.gson.Gson

class UserProfile : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var patientJson: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.navView.selectedItemId = R.id.navigationProfile

        patientJson = intent.getStringExtra("PATIENT").toString()
        val pat: Patient = Gson().fromJson(patientJson, Patient::class.java)
        "Full Patient Name: ${pat.name}".also { binding.fullPatientNameText.text = it }

        "Provider Name: ${pat.providerName}".also { binding.providerNameText.text = it }
        "Primary pain location: ${pat.painLocations[0]}".also {
            binding.primaryPainLocation.text = it
        }
        "Other pain location: ${pat.painLocations[1]}".also { binding.otherPainLocation.text = it }
        "Other pain location: ${pat.painLocations[2]}".also { binding.otherPainLocation2.text = it }

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    startActivity(Intent(this@UserProfile, Homescreen::class.java))
                }
                R.id.navigationData -> {
                    val intent = Intent(this@UserProfile, PatientSummary::class.java)
                    intent.putExtra("PATIENT", patientJson)
                    startActivity(intent)
                }
            }
            true
        }
    }


}