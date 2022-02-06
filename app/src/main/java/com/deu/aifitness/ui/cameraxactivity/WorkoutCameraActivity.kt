package com.deu.aifitness.ui.cameraxactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.databinding.ActivityWorkoutBinding
import com.deu.aifitness.databinding.ActivityWorkoutCameraBinding
import javax.inject.Inject

class WorkoutCameraActivity : AIFitnessActivity<WorkoutCameraVM,ActivityWorkoutCameraBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_workout_camera

    override fun getLayoutVM(): WorkoutCameraVM = cameraVM

    @Inject
    lateinit var cameraVM: WorkoutCameraVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(WorkoutCameraFragment())
    }

}