package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.painmanagementphysicianside.R
import com.example.painmanagementphysicianside.databinding.ActivityPatientSummaryBinding
import com.example.painmanagementphysicianside.databinding.ActivityPatientsBinding
import com.example.painmanagementphysicianside.models.Patient
import com.google.gson.Gson
import java.io.StringReader

class PatientSummary : AppCompatActivity() {

    private lateinit var binding: ActivityPatientSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientSummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pat: Patient = Gson().fromJson(intent.getStringExtra("PATIENT"), Patient::class.java)

        ("Patient: " + pat.name).also { binding.patientNameText.text = it }
        ("Age: " + pat.age).also { binding.patientAgeText.text = it }
    }

    fun onHome(item: MenuItem) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}