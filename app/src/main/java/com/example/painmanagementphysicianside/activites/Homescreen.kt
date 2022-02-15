package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.painmanagementphysicianside.R

class Homescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
    }

    fun onPatients(view: View) {
        val intent = Intent(this, Patients::class.java)
        startActivity(intent)
    }
    fun onData(view: View) {}
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