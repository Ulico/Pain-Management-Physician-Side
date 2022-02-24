package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.adrianrusso.painmanagementphysicianside.R

class TwoFactorAuthentication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_factor_authentication)
    }

    fun onPinEnter(view: View) {
        val intent = Intent(this, Homescreen::class.java)
        startActivity(intent)
    }
}