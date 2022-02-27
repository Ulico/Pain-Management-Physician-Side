package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adrianrusso.painmanagementphysicianside.R
import com.adrianrusso.painmanagementphysicianside.databinding.ActivityPatientSummaryBinding
import com.adrianrusso.painmanagementphysicianside.models.Patient
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

        patientJson = intent.getStringExtra("PATIENT").toString()
        val pat: Patient = Gson().fromJson(patientJson, Patient::class.java)

        "Patient: ${pat.name}".also { binding.patientNameText.text = it }
        "Age: ${pat.age}".also { binding.patientAgeText.text = it }

        "Most common pain location:\n${pat.painLocations[0]}".also {
            binding.painLocationText.text = it
        }
        "Most common treatment used:\n${pat.commonTreatments[0]}".also {
            binding.commonTreatmentText.text = it
        }
        "Most alternative treatment used:\n${pat.alternativeTreatments[0]}".also {
            binding.alternativeTreatmentText.text = it
        }
        "Notes:\n${pat.notes}".also { binding.notesString.text = it }

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