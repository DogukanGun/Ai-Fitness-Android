package com.deu.aifitness.ui.mainactivity

import android.content.Context
import android.content.Intent
import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageActivity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivityVM @Inject constructor(val apiSource: ApiSource):AIFitnessVM() {

    fun startTimer(){
        state.postValue(MainActivityVS.StartActivity)
    }

    fun sendStartRequest(){
        /*apiSource.registerUser(RegisterUser("","","","","","",""))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<RegisterUserResponse> {
                override fun onSubscribe(d: Disposable) {
                    print("bitti")
                }

                override fun onNext(t: RegisterUserResponse) {
                    print("devam")
                }

                override fun onError(e: Throwable) {
                    print("hata var")
                }

                override fun onComplete() {
                    print("tamamlandı")
                }

            })*/

    }
}