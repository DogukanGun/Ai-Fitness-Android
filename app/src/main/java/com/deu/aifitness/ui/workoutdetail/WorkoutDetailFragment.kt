package com.deu.aifitness.ui.workoutdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.session.IntentKey
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.databinding.FragmentWorkoutBinding
import com.deu.aifitness.databinding.FragmentWorkoutDetailBinding
import com.deu.aifitness.ui.cameraxactivity.WorkoutCameraActivity
import javax.inject.Inject

class WorkoutDetailFragment : AIFitnessFragment<WorkoutDetailVM,FragmentWorkoutDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_workout_detail

    override fun getLayoutVM(): WorkoutDetailVM = workoutDetailVM

    override fun hasBackButton(): Boolean = true

    private lateinit var workoutName:String

    @Inject
    lateinit var workoutDetailVM: WorkoutDetailVM

    companion object {
        fun getInstance(workoutName:String):WorkoutDetailFragment =
            WorkoutDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(IntentKey.WORKOUT_NAME.name,workoutName)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workoutName = arguments?.getString(IntentKey.WORKOUT_NAME.name) ?: ""
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        setAppBar()
        viewModel?.getWorkout(workoutName)
        return view
    }

    private fun setWorkout(workout:Workout){
        binding?.apply {
            this.exerciseNameTV.text = workout.workoutName
            this.valueFromCardView1TV.text = workout.workoutRating.toString()
        }
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            WorkoutDetailVS.StartWorkout->{
                startActivity(WorkoutCameraActivity::class.java)
            }
            WorkoutDetailVS.NegativeResponse ->{
                showNetworkError()
            }
            is WorkoutDetailVS.SetWorkout ->{
                setWorkout(state.workout)
            }
        }
    }
}