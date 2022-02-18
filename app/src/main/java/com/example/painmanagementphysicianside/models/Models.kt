package com.example.painmanagementphysicianside.models

class Physician(val name: String, val patients: List<String>) {
    constructor() : this("test", listOf("patient1", "patient2"))
}