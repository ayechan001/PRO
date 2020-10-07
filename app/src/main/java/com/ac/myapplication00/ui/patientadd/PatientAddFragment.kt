package com.ac.myapplication00.ui.patientadd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ac.myapplication00.R
import kotlinx.android.synthetic.main.fragment_patient_add.*

class PatientAddFragment : Fragment() {

    lateinit var patientAddViewModel: PatientAddViewModel

    lateinit var pet2 : String
    lateinit var pet3 : String
    lateinit var pet4 : String
    lateinit var pet5 : String
    lateinit var pet6 : String
    lateinit var pet7 : String
    lateinit var pet8 : String
    lateinit var pet9 : String
    lateinit var pet10 : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayOf("Male","Female")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (pe3.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        btn_Save.setOnClickListener {
            Toast.makeText(context,"Successfully",Toast.LENGTH_LONG).show()

            pet2 = pe2.text.toString()

            pet4 = pe4.text.toString()
            pet5 = pe5.text.toString()
            pet6 = pe6.text.toString()
            pet7 = pe7.text.toString()
            pet8 = pe8.text.toString()
            pet9 = pe9.text.toString()
            pet10 = pe10.text.toString()

            patientviewmodel(pet2,pet3,pet4,pet5,pet6,pet7,pet8,pet9)
        }
    }

    private fun patientviewmodel(name : String , gender : String , dob : String ,  image : String , phone_no : String , alternative_phone_no : String , address : String , description : String){
        patientAddViewModel.loadPatientAdd(name , gender , dob ,  image , phone_no , alternative_phone_no , address  , description)
        patientAddViewModel.getPatientAdd()
    }
}