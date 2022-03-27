package com.deu.aifitness.ui.cameraxactivity

import android.database.Observable
import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.workout.UploadWorkoutRequest
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkoutCameraFragmentVM @Inject constructor(
    val apiSource: ApiSource
): AIFitnessVM() {

    fun uploadImages(uploadWorkoutRequest: UploadWorkoutRequest){
        apiSource.uploadWorkout(uploadWorkoutRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<UploadWorkoutRequest>{
                override fun onSubscribe(d: Disposable) {
                    state.postValue(WorkoutCameraFragmentVS.ImageUploaded)
                }

                override fun onNext(t: UploadWorkoutRequest) {
                    state.postValue(WorkoutCameraFragmentVS.ResultCame(t))
                }

                override fun onError(e: Throwable) {
                    state.postValue(WorkoutCameraFragmentVS.Error)
                }

                override fun onComplete() { }

            })
    }

    fun startWaiting(){
        state.postValue(WorkoutCameraFragmentVS.StartWaiting)
    }
}