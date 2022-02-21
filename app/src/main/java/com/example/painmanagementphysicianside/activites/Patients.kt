package com.example.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.painmanagementphysicianside.adapters.PatientListAdapter
import com.example.painmanagementphysicianside.databinding.ActivityPatientsBinding
import com.example.painmanagementphysicianside.models.Patient
import com.example.painmanagementphysicianside.models.Physician
import com.example.painmanagementphysicianside.models.User
import com.google.gson.Gson

class Patients : AppCompatActivity() {
    private lateinit var binding: ActivityPatientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.patientList.adapter = PatientListAdapter(
            this, User.patients.sortedBy { pat -> pat.name.substringAfterLast(" ") }
        )

        binding.patientList.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val intent = Intent(this, PatientSummary::class.java)
                val pat = binding.patientList.adapter.getItem(position) as Patient
                intent.putExtra("PATIENT", Gson().toJson(pat))
                startActivity(intent)
            }

        binding.patientEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(text: Editable?) {
                (binding.patientList.adapter as PatientListAdapter).updateData(
                    User.patients.filter { p ->
                        p.name.contains(text!!, true)
                    }
                )
            }
        })
    }

    fun onHome(view: View) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}