package com.example.painmanagementphysicianside.models

class Physician(val name: String, val patients: List<Patient>) {
}

class Patient(val name: String, val age: Int, val status: Boolean) {

}
