package com.deu.aifitness.ui.user.operation.fragment

import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.application.AISessionManager
import com.deu.aifitness.data.form.AlternativeOperation
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.data.session.SessionKey
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserOperationFragmentVM @Inject constructor(val apiSource: ApiSource,
                                                  val aiSession: AISessionManager):AIFitnessVM() {

    fun alternativeRegisterPressed(alternativeOperation: AlternativeOperation){
        state.postValue(UserOperationFragmentVS.StartLauncher(alternativeOperation))
    }

    fun alternativeLoginPressed(alternativeOperation: AlternativeOperation){
        state.postValue(UserOperationFragmentVS.StartLauncher(alternativeOperation))
    }

    fun registerUser(user: RegisterUser) {
        apiSource.registerUser(user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<RegisterUserResponse> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: RegisterUserResponse) {
                    print("devam")
                    val loginUser = LoginUser(user.username,user.password)
                    state.postValue(UserOperationFragmentVS.LoginUserComingFromRegister(loginUser = loginUser))
                }

                override fun onError(e: Throwable) {
                    state.postValue(UserOperationFragmentVS.UserOperationError)
                }

                override fun onComplete() {
                    print("tamamlandı")
                }

            })

    }
    fun loginUser(login: LoginUser) {
        apiSource.loginUser(login)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<LoginUserResponse> {
                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: LoginUserResponse) {
                    aiSession.putData(SessionKey.USER_TOKEN.name,t.token)
                    state.postValue(UserOperationFragmentVS.UserOperationDone)
                }

                override fun onError(e: Throwable) {
                    state.postValue(UserOperationFragmentVS.UserOperationError)
                }

                override fun onComplete() {}

            })

    }
}