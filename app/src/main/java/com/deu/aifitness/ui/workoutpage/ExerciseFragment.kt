package com.deu.aifitness.ui.workoutpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.databinding.FragmentExerciseBinding
import javax.inject.Inject

class ExerciseFragment : AIFitnessFragment<ExerciseVM,FragmentExerciseBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_exercise

    override fun getLayoutVM(): ExerciseVM = exerciseVM

    @Inject
    lateinit var exerciseVM: ExerciseVM



}