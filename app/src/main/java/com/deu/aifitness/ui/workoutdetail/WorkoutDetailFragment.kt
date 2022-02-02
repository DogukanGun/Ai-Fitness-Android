package com.deu.aifitness.ui.workoutdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.databinding.FragmentWorkoutBinding
import javax.inject.Inject

class WorkoutDetailFragment : AIFitnessFragment<WorkoutDetailVM,FragmentWorkoutBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_workout_detail

    override fun getLayoutVM(): WorkoutDetailVM = workoutDetailVM

    @Inject
    lateinit var workoutDetailVM: WorkoutDetailVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }

}