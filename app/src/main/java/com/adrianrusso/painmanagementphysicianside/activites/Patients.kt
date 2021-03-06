package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.adrianrusso.painmanagementphysicianside.adapters.PatientListAdapter
import com.adrianrusso.painmanagementphysicianside.databinding.ActivityPatientsBinding
import com.adrianrusso.painmanagementphysicianside.models.Patient
import com.adrianrusso.painmanagementphysicianside.models.AppUser
import com.google.gson.Gson

class Patients : AppCompatActivity() {
    private lateinit var binding: ActivityPatientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.patientList.adapter = PatientListAdapter(
            this, AppUser.patients.sortedBy { pat -> pat.name.substringAfterLast(" ") }
        )

        //(binding.patientList.adapter as PatientListAdapter).getListNames()
        binding.patientGraph.settings.domStorageEnabled = true
        binding.patientGraph.settings.javaScriptEnabled = true
        binding.patientGraph.loadUrl("file:///android_asset/graph.html")
        binding.patientGraph.addJavascriptInterface(WebAppInterface(this, (binding.patientList.adapter as PatientListAdapter)), "Android")

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
                require(text != null)
                (binding.patientList.adapter as PatientListAdapter).updateData(
                    AppUser.patients.filter { p ->
                        p.name.contains(text, true)
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