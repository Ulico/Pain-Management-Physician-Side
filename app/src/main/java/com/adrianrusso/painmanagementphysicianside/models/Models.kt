package com.adrianrusso.painmanagementphysicianside.models

import android.util.Log
import com.google.gson.Gson
import io.realm.mongodb.User
import io.realm.mongodb.mongo.MongoClient
import io.realm.mongodb.mongo.MongoCollection
import io.realm.mongodb.mongo.MongoDatabase
import org.bson.Document
import java.io.FileReader

object AppUser {

    var name: String = ""
    var patients: MutableList<Patient> = mutableListOf()
    lateinit var mdbUser: User

    @Suppress("UNCHECKED_CAST")
    fun loadInfo(user: User) {
        mdbUser = user
        val mongoClient: MongoClient =
            user.getMongoClient("mongodb-atlas")!! // service for MongoDB Atlas cluster containing custom user data
        val mongoDatabase: MongoDatabase =
            mongoClient.getDatabase("pain-management-database")!!
        val mongoCollection: MongoCollection<Document> =
            mongoDatabase.getCollection("users-info")!!
        val customUserData: Document? = user.customData
        require(customUserData != null)
        name = customUserData["name"] as String
        val patientIdList: List<String> = customUserData["patients"] as List<String>
        for (patientId in patientIdList) {
            mongoCollection.findOne(Document("_id", patientId))
                .getAsync { task ->
                    if (task.isSuccess) {
                        val result = task.get()
                        Log.d("AppData", result.toString())
                        val p = Gson().fromJson(result.toJson(), Patient::class.java)
                        Log.d("AppData", p.toString())
                        patients.add(
                            p
//                            Patient(
//                                result["name"] as String,
//                                result["age"] as Int,
//                                result["status"] as Boolean,
//                                result["provider_name"] as String,
//                                result["pain_locations"] as List<String>,
//                                result["treatments"] as List<String>,
//                                result["alternative_treatments"] as List<String>,
//                                result["notes"] as String
//
//                            )
                        )
                    } else {
                        Log.e("AppUser", "failed to find document with: ${task.error}")
                    }
                }
        }
    }
}

data class Patient(
    val name: String,
    val age: Int,
    val status: Boolean,
    val providerName: String,
    val painLocations: List<String>,
    val commonTreatments: List<String>,
    val alternativeTreatments: List<String>,
    val notes: String
)
