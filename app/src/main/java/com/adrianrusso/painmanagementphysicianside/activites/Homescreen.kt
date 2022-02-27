package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adrianrusso.painmanagementphysicianside.R
import com.adrianrusso.painmanagementphysicianside.databinding.ActivityHomescreenBinding
import com.adrianrusso.painmanagementphysicianside.databinding.ActivityMainBinding
import com.adrianrusso.painmanagementphysicianside.models.Patient
import com.adrianrusso.painmanagementphysicianside.models.AppUser

class Homescreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomescreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        "Welcome, ${AppUser.name}".also { binding.welcomeText.text = it }
    }

    fun onPatients(view: View) {
        val intent = Intent(this, Patients::class.java)
        startActivity(intent)
    }

    fun onMessages(view: View) {
        val intent = Intent(this, Messages::class.java)
        startActivity(intent)
    }

    fun onAccount(view: View) {}
    fun onLogout(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}