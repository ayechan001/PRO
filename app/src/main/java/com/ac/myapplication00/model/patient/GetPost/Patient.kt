package com.ac.myapplication00.model.patient.GetPost

data class Patient(
    val address: String,
    val alternative_phone_no: String,
    val created_at: String,
    val description: String,
    val dob: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val phone_no: String,
    val updated_at: String
)