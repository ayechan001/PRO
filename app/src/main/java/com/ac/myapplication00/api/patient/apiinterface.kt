package com.ac.myapplication00.api.patient

import com.ac.myapplication00.model.patient.GetPost.patientmodel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface apiinterface {

    //Post
    @FormUrlEncoded
    @POST("patient")
    fun addAllpatient(
        @Field("name") name: String,
        @Field("gender") gender: String,
        @Field("dob") dob: String,
        @Field("image") image: String,
        @Field("phone_no") phone_no: String,
        @Field("alternative_phone_no") alternative_phone_no: String,
        @Field("address") address: String,
        @Field("description") description: String
    ): Call<patientmodel>

    @GET("patient")
    fun getAllpatient(): Call<patientmodel>

}