package com.ac.myapplication00.ui.patientlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ac.myapplication00.api.patient.apiclient
import com.ac.myapplication00.model.patient.GetPost.patientmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientListViewModel : ViewModel(){
    private var patient : MutableLiveData<patientmodel> = MutableLiveData()

//    //Loading
//    private var loading : MutableLiveData<Boolean> = MutableLiveData()
//
//    fun getLoading() : LiveData<Boolean> = loading

    fun getpatient() : LiveData<patientmodel> = patient

    fun loadpatient() {
        var apiClient = apiclient()
        val callapi = apiClient.getPatientClient()

        callapi.enqueue(object : Callback<patientmodel> {
            override fun onFailure(call: Call<patientmodel>, t: Throwable) {
                Log.d("error" , t.toString())
//                loading.value = false
            }

            override fun onResponse(call: Call<patientmodel>, response: Response<patientmodel>) {
                patient.value = response.body()!!
                Log.d("data",patient.toString())
//                loading.value = true
            }

        })
    }
}