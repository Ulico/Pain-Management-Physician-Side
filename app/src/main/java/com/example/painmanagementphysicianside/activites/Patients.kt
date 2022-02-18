package com.example.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.painmanagementphysicianside.adapters.PatientListAdapter
import com.example.painmanagementphysicianside.databinding.ActivityPatientsBinding

class Patients : AppCompatActivity() {
    private lateinit var binding: ActivityPatientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.patientList.adapter = PatientListAdapter(this)
        binding.patientList.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                startActivity(
                    Intent(
                        this,
                        PatientSummary::class.java
                    )
                )
            }
    }

    fun onHome(view: View) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}