package com.ac.myapplication00.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.ac.myapplication00.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var mViewPager : ViewPager

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        val root =
            return inflater.inflate(R.layout.fragment_home, container, false)
//        mViewPager=root.findViewById(R.id.navslider)
//        val viewitem = arrayOf(R.drawable.font)
////        val textView: TextView = root.findViewById(R.id.text_home)
////        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//////            textView.text = it
////            viewitem.
////        })
//         return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewitem = arrayOf(R.drawable.font)

        one.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_patientListFragment)
        }
        two.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_appointmentFragment)
        }
        three.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_patientAddFragment)
        }


    }
}