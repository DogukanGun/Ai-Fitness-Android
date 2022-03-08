package com.deu.aifitness.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.profile.Profile
import com.deu.aifitness.data.profile.ProfileEntity
import com.deu.aifitness.data.profile.ProfileResponse
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileVM @Inject constructor(val apiSource: ApiSource):AIFitnessVM() {
    var profile = MutableLiveData(ProfileEntity("","",""))

    fun getProfile(){

    }

    fun updateProfile(profile:Profile){
        apiSource.updateProfile(profile)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<ProfileResponse>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: ProfileResponse) {
                    if(t.success) {
                        state.postValue(ProfileVS.PositiveResponse)
                    }else{
                        state.postValue(ProfileVS.NegativeResponse)
                    }
                }

                override fun onError(e: Throwable) {
                    state.postValue(ProfileVS.NegativeResponse)
                }

                override fun onComplete() {

                }

            })
    }
}