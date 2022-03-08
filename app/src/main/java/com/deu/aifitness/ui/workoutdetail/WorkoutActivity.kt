package com.deu.aifitness.ui.workoutdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.data.session.IntentKey
import com.deu.aifitness.databinding.ActivityWorkoutBinding
import javax.inject.Inject

class WorkoutActivity : AIFitnessActivity<WorkoutActivityVM,ActivityWorkoutBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_workout

    override fun getLayoutVM(): WorkoutActivityVM = workoutActivityVM

    @Inject
    lateinit var workoutActivityVM: WorkoutActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getStringExtra(IntentKey.WORKOUT_NAME.name)?.let { workoutName ->
            addFragment(WorkoutDetailFragment.getInstance(workoutName))
        }
    }
}