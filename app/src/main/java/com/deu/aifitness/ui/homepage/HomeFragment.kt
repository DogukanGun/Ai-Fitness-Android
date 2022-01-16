package com.deu.aifitness.ui.homepage

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : AIFitnessFragment<HomeFragmentVM,FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getLayoutVM(): HomeFragmentVM = homeFragmentVM

    @Inject
    lateinit var homeFragmentVM: HomeFragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding!!.exerciseItemRecyclerview.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)
        binding!!.exerciseItemRecyclerview.adapter = RecyclerAdapter()
        return view
    }



}