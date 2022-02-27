package com.adrianrusso.painmanagementphysicianside.activites

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adrianrusso.painmanagementphysicianside.databinding.ActivityMainBinding
import com.adrianrusso.painmanagementphysicianside.models.AppUser
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.mongo.MongoClient
import io.realm.mongodb.mongo.MongoCollection
import io.realm.mongodb.mongo.MongoDatabase
import io.realm.mongodb.mongo.options.UpdateOptions
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId

lateinit var taskApp: App
const val appID = "test_app-svywj"

class MainActivity : AppCompatActivity() {

    var user: User? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        user = null
        binding.password.text.clear()

        Realm.init(this)
        taskApp = App(
            AppConfiguration.Builder(appID)
                .build()
        )


    }

    fun onLogIn(view: View) {
        if (binding.username.text.isEmpty() || binding.password.text.isEmpty()) {
            Snackbar.make(
                binding.root,
                "Please enter your username and password.",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }

        val emailPasswordCredentials: Credentials = Credentials.emailPassword(
            binding.username.text.toString(),
            binding.password.text.toString()
        )

        taskApp.loginAsync(emailPasswordCredentials) {
            if (it.isSuccess) {
                user = taskApp.currentUser()

                AppUser.loadInfo(user!!)

//                val mongoClient: MongoClient =
//                    user?.getMongoClient("mongodb-atlas")!! // service for MongoDB Atlas cluster containing custom user data
//                val mongoDatabase: MongoDatabase =
//                    mongoClient.getDatabase("pain-management-database")!!
//                val mongoCollection: MongoCollection<Document> =
//                    mongoDatabase.getCollection("users-info")!!
//                val arr = listOf("34234", "3425234")
//                mongoCollection.insertOne(
//                    Document("_id", user!!.id).append("name", "Robert Smith")
//                        .append("patients", arr)
//                )
//                    .getAsync { result ->
//                        if (result.isSuccess) {
//                            Log.v(
//                                "EXAMPLE",
//                                "Inserted custom user data document. _id of inserted document: ${result.get().insertedId}"
//                            )
//
//                        } else {
//                            Log.e(
//                                "EXAMPLE",
//                                "Unable to insert custom user data. Error: ${result.error}"
//                            )
//                        }
//                    }
//                val customUserData : Document? = user?.customData
//                Log.v("EXAMPLE", "Fetched custom user data: $customUserData")
//                val mongoClient : MongoClient =
//                    user?.getMongoClient("mongodb-atlas")!! // service for MongoDB Atlas cluster containing custom user data
//                val mongoDatabase : MongoDatabase =
//                    mongoClient.getDatabase("myTest")!!
//                val mongoCollection : MongoCollection<Document> =
//                    mongoDatabase.getCollection("test_collection")!!
//                com.adrianrusso.painmanagementphysicianside.models.User.name = "Billy"
//                mongoCollection.updateOne(Document("_id", user!!.id), Document("\$set", Document("user", com.adrianrusso.painmanagementphysicianside.models.User)))
//                    .getAsync { result ->
//                        if (result.isSuccess) {
//                            if (result.get().modifiedCount == 1L) {
//                                Log.v("EXAMPLE", "Updated custom user data document.")
//                            } else {
//                                Log.v("EXAMPLE", "Could not find custom user data document to update.")
//                            }
//                        } else {
//                            Log.e("EXAMPLE", "Unable to update custom user data. Error: ${result.error}")
//                        }
//                    }

//                val queryFilter = Document("_id", ObjectId(user!!.id))
//                mongoCollection.findOne(queryFilter)
//                    .getAsync { task ->
//                        if (task.isSuccess) {
//                            val result = task.get()
//                            Log.v("EXAMPLE", "successfully found a document: $result")
//                        } else {
//                            Log.e("EXAMPLE", "failed to find document with: ${task.error}")
//                        }
//                    }

                val intent = Intent(this, TwoFactorAuthentication::class.java)
                startActivity(intent)
            } else {
                it.error.errorMessage?.let { it1 ->
                    Snackbar.make(
                        binding.root,
                        it1,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun onHelp(view: View) {
        val intent = Intent(this, HelpSection::class.java)
        startActivity(intent)
    }
}