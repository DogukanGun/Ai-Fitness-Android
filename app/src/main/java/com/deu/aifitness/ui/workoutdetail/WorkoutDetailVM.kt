package com.deu.aifitness.ui.workoutdetail

import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkoutDetailVM @Inject constructor(val apiSource: ApiSource): AIFitnessVM() {

    fun buttonPressed(){
        state.postValue(WorkoutDetailVS.StartWorkout)
    }

    fun getWorkout(workoutName:String){
        apiSource.getWorkout(workoutName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<List<Workout>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<Workout>) {
                    state.postValue(WorkoutDetailVS.SetWorkout(t[0]))
                }

                override fun onError(e: Throwable) {
                    state.postValue(WorkoutDetailVS.NegativeResponse)
                }

                override fun onComplete() {
                }

            })
    }
}