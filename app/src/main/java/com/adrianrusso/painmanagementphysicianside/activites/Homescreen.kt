package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adrianrusso.painmanagementphysicianside.R
import com.adrianrusso.painmanagementphysicianside.models.Patient
import com.adrianrusso.painmanagementphysicianside.models.User

class Homescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        User.name = "Robert Smith"
        User.patients = mutableListOf(
            Patient("Marshall Lawson", 63, true),
            Patient("Shawna Bowers", 47, false),
            Patient("Latoya Tyler", 64, false),
            Patient("Jacquelyn Blair", 45, true),
            Patient("Angelica Hall", 34, true),
            Patient("Sandy Romero", 96, false),
            Patient("Kelly Murray", 64, false),
            Patient("Monique Baldwin", 45, true),
            Patient("Scott Bowman", 34, true),
            Patient("Ed Gibson", 96, false)
        )
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