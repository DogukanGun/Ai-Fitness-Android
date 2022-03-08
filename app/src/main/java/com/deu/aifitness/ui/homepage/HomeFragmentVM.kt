package com.deu.aifitness.ui.homepage

import io.reactivex.Observer
import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.network.ApiSource
import com.google.android.material.chip.Chip
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentVM @Inject constructor(val apiSource: ApiSource):AIFitnessVM() {

    private val filterList = mutableListOf<String>()
    private var workoutList = listOf<Workout>()

    fun getWorkouts(){
           apiSource.getAllWorkouts()
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe(object :Observer<List<Workout>>{
                   override fun onSubscribe(d: Disposable) {

                   }

                   override fun onNext(t: List<Workout>) {
                       workoutList = t
                       state.postValue(HomeVS.SetWorkouts(t.slice(0..3),filterList.toList()))
                   }

                   override fun onError(e: Throwable) {
                       state.postValue(HomeVS.NetworkError)
                   }

                   override fun onComplete() {
                   }

               })
    }

    fun addFilter(chip:Chip){
        if (chip.isChecked){
            filterList.add(chip.text.toString())
        }else{
            filterList.remove(chip.text.toString())
        }
        state.postValue(HomeVS.SetWorkouts(workoutList,filterList.toList()))
    }
}