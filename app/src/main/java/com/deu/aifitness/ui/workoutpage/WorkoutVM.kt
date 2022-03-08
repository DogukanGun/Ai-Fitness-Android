package com.deu.aifitness.ui.workoutpage

import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.homepage.HomeVS
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkoutVM @Inject constructor(val apiSource: ApiSource): AIFitnessVM() {

    fun getWorkouts(){
        apiSource.getAllWorkouts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<Workout>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<Workout>) {
                    state.postValue(WorkoutVS.SetWorkouts(t))
                }

                override fun onError(e: Throwable) {
                    state.postValue(WorkoutVS.NetworkError)
                }

                override fun onComplete() {
                }

            })
    }
}