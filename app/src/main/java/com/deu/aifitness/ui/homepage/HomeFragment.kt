package com.deu.aifitness.ui.homepage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.databinding.FragmentHomeBinding
import com.google.android.material.chip.Chip
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
        binding?.chip1C?.setOnClickListener(chipListener)
        binding?.chip2C?.setOnClickListener(chipListener)
        binding?.chip3C?.setOnClickListener(chipListener)
        binding?.chip4C?.setOnClickListener(chipListener)
        binding?.chip5C?.setOnClickListener(chipListener)
        showProgress()
        viewModel?.getWorkouts()
        viewModel?.getName()
        return view
    }

    private fun setAdapter(workoutList:List<Workout>,filterList:List<String>){
        binding?.apply {
            exerciseItemRecyclerview.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)
            if (filterList.isNotEmpty()){
                val filteredWorkoutList = workoutList.filter {
                    var flag = false
                    for (filterItem in filterList){
                        if (it.workoutName.contains(filterItem)){
                            flag = true
                        }
                    }
                    flag
                }
                exerciseItemRecyclerview.adapter = RecyclerAdapter(filteredWorkoutList)
            }else{
                exerciseItemRecyclerview.adapter = RecyclerAdapter(workoutList)
            }

        }
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            is HomeVS.SetWorkouts ->{
                showProgress()
                setAdapter(state.workouts,state.filter)
            }
            HomeVS.NetworkError -> {
                showErrorProgress()
                showNetworkError()
            }
            is HomeVS.SetUsername ->{
                setUsername(state.username)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUsername(username:String){
        binding?.userNameTV?.text = "Hey $username"
    }

    private val chipListener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            (v as Chip?)?.let { chip->
                viewModel?.addFilter(chip)
            }
        }
    }

}