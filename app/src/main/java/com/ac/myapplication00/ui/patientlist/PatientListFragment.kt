package com.ac.myapplication00.ui.patientlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ac.myapplication00.R
import kotlinx.android.synthetic.main.fragment_patient_list.*

class PatientListFragment : Fragment() {

    lateinit var patientListAdapter: PatientListAdapter
    lateinit var patientListViewModel: PatientListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        patientListViewModel = ViewModelProvider(this).get(PatientListViewModel::class.java)
        patientListAdapter = PatientListAdapter()

        recyclerview_patientlist.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = patientListAdapter
        }

        ViewModel()
    }

    private fun ViewModel(){
        patientListViewModel.loadpatient()
        patientListViewModel.getpatient().observe(
            viewLifecycleOwner , Observer { AboutKnowledge ->
                patientListAdapter.updatePatient(AboutKnowledge.patients)
            }
        )
    }
}