package com.deu.aifitness.ui.user.register

import android.content.Context
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class RegisterVM @Inject constructor(val context: Context, private val apiSource:ApiSource) {

    fun registerUser(user:RegisterUser) {
        apiSource.registerUser(user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object:Observer<RegisterUserResponse>{
                override fun onSubscribe(d: Disposable) {
                    TODO("Not yet implemented")
                }

                override fun onNext(t: RegisterUserResponse) {
                    TODO("Not yet implemented")
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })

    }
}