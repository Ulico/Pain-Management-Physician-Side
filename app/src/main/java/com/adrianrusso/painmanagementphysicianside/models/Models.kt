package com.adrianrusso.painmanagementphysicianside.models

object User {

    var name: String = ""
    var patients: MutableList<Patient> = mutableListOf()


}

class Patient(val name: String, val age: Int, val status: Boolean) {

}
