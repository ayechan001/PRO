package com.ac.myapplication00.api.patient

import com.ac.myapplication00.model.patient.GetPost.patientmodel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiclient {
    private val BASE_URL = "http://patientappointmentapi.dsv.hoz.mybluehost.me/api/setup/"

    private val Apiinterface : apiinterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        Apiinterface = retrofit.create(apiinterface::class.java)
    }

    fun getPatientClient() : Call<patientmodel> {
        return Apiinterface.getAllpatient()
    }

    fun addPatientClient(name : String , gender : String , dob : String ,  image : String , phone_no : String , alternative_phone_no : String , address : String , description : String) : Call<patientmodel>{
        return Apiinterface.addAllpatient(name , gender , dob ,  image , phone_no , alternative_phone_no , address  , description)
    }
}