package com.deu.aifitness.ui.workoutpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.databinding.FragmentWorkoutBinding
import javax.inject.Inject

class WorkoutFragment : AIFitnessFragment<WorkoutVM,FragmentWorkoutBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_workout

    override fun getLayoutVM(): WorkoutVM = workoutVM

    @Inject
    lateinit var workoutVM: WorkoutVM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        val includeEdge = true
        binding?.workoutRV?.apply {
            adapter = WorkoutAdapter(listOf())
            layoutManager = GridLayoutManager(requireContext(),2)
        }

        return view
    }

}