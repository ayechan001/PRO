package com.ac.myapplication00.ui.patientadd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ac.myapplication00.api.patient.apiclient
import com.ac.myapplication00.model.patient.GetPost.patientmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientAddViewModel: ViewModel() {
    private val PatientAdd : MutableLiveData<patientmodel> = MutableLiveData()

    fun getPatientAdd() : LiveData<patientmodel> = PatientAdd

    fun loadPatientAdd(name : String , gender : String , dob : String ,  image : String , phone_no : String , alternative_phone_no : String , address : String , description : String) {
        var apiclient = apiclient()
        var apicall = apiclient.addPatientClient(name , gender , dob ,  image , phone_no , alternative_phone_no , address  , description)

        apicall.enqueue(object : Callback<patientmodel>{
            override fun onFailure(call: Call<patientmodel>, t: Throwable) {
                Log.d("error" , t.toString())
            }

            override fun onResponse(call: Call<patientmodel>, response: Response<patientmodel>) {
                PatientAdd.value = response.body()!!
                Log.d("data",PatientAdd.value.toString())
            }

        })
    }
}