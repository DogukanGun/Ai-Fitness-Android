package com.deu.aifitness.ui.workoutdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.databinding.FragmentWorkoutBinding
import com.deu.aifitness.ui.cameraxactivity.WorkoutCameraActivity
import javax.inject.Inject

class WorkoutDetailFragment : AIFitnessFragment<WorkoutDetailVM,FragmentWorkoutBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_workout_detail

    override fun getLayoutVM(): WorkoutDetailVM = workoutDetailVM

    override fun hasBackButton(): Boolean = true

    @Inject
    lateinit var workoutDetailVM: WorkoutDetailVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        setAppBar()
        return view
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            WorkoutDetailVS.StartWorkout->{
                startActivity(WorkoutCameraActivity::class.java)
            }
        }
    }
}