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

class Patients : AppCompatActivity() {
    private lateinit var binding: ActivityPatientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val p = Physician(
            "Robert Smith", listOf(
                Patient("Jane Doe", 63, true),
                Patient("John Coe", 47, false),
                Patient("Josh Foe", 64, false),
                Patient("James Loe", 45, true),
                Patient("Jill Doe", 34, true),
                Patient("Jack Doe", 96, false)
            )
        )

        binding.patientList.adapter = PatientListAdapter(
            this, p.patients.sortedBy { pat -> pat.name.substringAfterLast(" ") }
        )
        binding.patientList.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                startActivity(
                    Intent(
                        this,
                        PatientSummary::class.java
                    )
                )
            }

        binding.patientEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(text: Editable?) {
                (binding.patientList.adapter as PatientListAdapter).updateData(
                    p.patients.filter { p ->
                        p.name.contains(
                            text!!, true
                        )
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