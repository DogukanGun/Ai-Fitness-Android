package com.deu.aifitness.ui.workoutpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
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
        viewModel?.getWorkouts()
        return view
    }

    private fun startExerciseDetail(){
        startActivity(WorkoutActivity::class.java)
    }

    private fun setAdapter(workoutList:List<Workout>){
        binding?.workoutRV?.apply {
            val workoutAdapter = WorkoutAdapter(workoutList)
            workoutAdapter.listener = workoutAdapterListener
            adapter = workoutAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            is WorkoutVS.SetWorkouts ->{
                setAdapter(state.workoutList)
            }
            WorkoutVS.NetworkError ->{
                showNetworkError()
            }
        }
    }

    private val workoutAdapterListener = object: WorkoutListener{
        override fun workoutClicked(workout: Workout) {
            startExerciseDetail()
        }
    }
}