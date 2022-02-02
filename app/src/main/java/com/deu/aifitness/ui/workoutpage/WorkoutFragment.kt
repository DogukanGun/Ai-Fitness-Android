package com.deu.aifitness.ui.workoutpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.databinding.FragmentWorkoutBinding
import com.deu.aifitness.ui.workoutdetail.WorkoutActivity
import com.deu.aifitness.ui.workoutdetail.WorkoutDetailFragment
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
        binding?.workoutRV?.apply {
            val workoutAdapter = WorkoutAdapter(listOf(Workout("","dsd",4,"sadasd","adadasd")))
            workoutAdapter.listener = workoutAdapterListener
            adapter = workoutAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }

        return view
    }

    private fun startExerciseDetail(){
        startActivity(WorkoutActivity::class.java)
    }

    private val workoutAdapterListener = object: WorkoutListener{
        override fun workoutClicked(workout: Workout) {
            startExerciseDetail()
        }
    }
}