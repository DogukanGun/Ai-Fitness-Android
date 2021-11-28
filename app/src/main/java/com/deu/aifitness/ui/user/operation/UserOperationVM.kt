package com.deu.aifitness.ui.user.operation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

// TODO: 28.11.2021 Buraya context eklenmeli

class UserOperationVM : ViewModel() {

    @Inject
    lateinit var apiSource:ApiSource
    fun registerUser(user:RegisterUser) {
        apiSource.registerUser(user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object:Observer<RegisterUserResponse>{
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

            })

    }
    fun loginUser(login:LoginUser) {
        apiSource.loginUser(login)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object:Observer<LoginUserResponse>{
                override fun onSubscribe(d: Disposable) {
                    print("bitti")
                }

                override fun onNext(t: LoginUserResponse) {
                    print("devam")
                }

                override fun onError(e: Throwable) {
                    print("hata var")
                }

                override fun onComplete() {
                    print("bitti")
                }

            })

    }
}