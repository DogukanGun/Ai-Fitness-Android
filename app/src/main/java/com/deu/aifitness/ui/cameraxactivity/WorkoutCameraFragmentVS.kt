package com.deu.aifitness.ui.cameraxactivity

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.workout.UploadWorkoutRequest

sealed class WorkoutCameraFragmentVS: AIFitnessState {
    object ImageUploaded: WorkoutCameraFragmentVS()
    object StartWaiting: WorkoutCameraFragmentVS()
    class ResultCame(val uploadWorkoutRequest: UploadWorkoutRequest): WorkoutCameraFragmentVS()
    object Error: WorkoutCameraFragmentVS()
}