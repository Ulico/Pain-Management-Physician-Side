package com.example.painmanagementphysicianside.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.painmanagementphysicianside.R
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User

lateinit var taskApp: App
class MainActivity : AppCompatActivity() {
    val appID = "test_app-svywj"
    var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        taskApp = App(
            AppConfiguration.Builder(appID)
                .build()
        )

    }

    fun onLogIn(view: View) {
        val emailPasswordCredentials: Credentials = Credentials.emailPassword(
            "aruss8@illinois.edu",
            "test123"
        )

        taskApp.loginAsync(emailPasswordCredentials) {
            if (it.isSuccess) {
                user = taskApp.currentUser()


                val intent = Intent(this, TwoFactorAuthentication::class.java)
                startActivity(intent)
            }
        }
    }

    fun onHelp(view: View) {
        val intent = Intent(this, HelpSection::class.java)
        startActivity(intent)
    }
}