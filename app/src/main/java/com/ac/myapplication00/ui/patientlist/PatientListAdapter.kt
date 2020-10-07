package com.ac.myapplication00.ui.patientlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ac.myapplication00.R
import com.ac.myapplication00.model.patient.GetPost.Patient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.patientlist.view.*

class PatientListAdapter (var PatientList : List<Patient> = ArrayList<Patient>()) : RecyclerView.Adapter<PatientListAdapter.PatientViewHolder>(){

//    var knowledgeClickListener : KnowledgeClickListener ?= null
//
//    fun setOnClickListener(clickListener: KnowledgeClickListener){
//        this.knowledgeClickListener = clickListener
//    }

    //, View.OnClickListener
    inner class PatientViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

//        lateinit var knowledge : Patient
//
//        init {
//            itemView.setOnClickListener(this)
//        }

        fun bind(patient: Patient){
//            this.knowledge = knowledge
            Picasso.get().load("http://patientappointmentapi.dsv.hoz.mybluehost.me/" + patient.image).into(itemView.image)
            itemView.textview1.text = patient.name
            itemView.textview2.text = patient.dob
        }

//        override fun onClick(p0: View?) {
//            knowledgeClickListener?.onClick(knowledge)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patientlist, parent, false)
        return PatientViewHolder(view)
    }

    override fun getItemCount(): Int {
        return PatientList.size
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        holder.bind(PatientList[position])
    }

    fun updatePatient(Patient : List<Patient>){
        this.PatientList = Patient
        notifyDataSetChanged()
    }

//    interface KnowledgeClickListener{
//        fun onClick(knowledge: Patient)
//    }
}