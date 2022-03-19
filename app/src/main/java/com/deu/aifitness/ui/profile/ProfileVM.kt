package com.deu.aifitness.ui.profile

import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.application.AISessionManager
import com.deu.aifitness.data.profile.*
import com.deu.aifitness.data.session.SessionKey
import com.deu.aifitness.network.ApiSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileVM @Inject constructor(
    val session: AISessionManager,
    val apiSource: ApiSource):AIFitnessVM() {
    var profile = UpdateProfileRequest("","","")


    fun updateProfileImage(updateProfileImageRequest: UpdateProfileImageRequest){
        val username = session.getData<String>(SessionKey.USERNAME.name)
        updateProfileImageRequest.username = username ?: ""
        apiSource.updateProfileImage(updateProfileImageRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<ProfileEntity>{
                override fun onSubscribe(d: Disposable) { }
                override fun onNext(t: ProfileEntity) {
                    state.postValue(ProfileVS.PositiveResponseFromUpdateProfileImage)
                }
                override fun onError(e: Throwable) {
                    state.postValue(ProfileVS.Error)
                }
                override fun onComplete() { }
            })
    }

    fun getProfile(){
        val username = session.getData<String>(SessionKey.USERNAME.name)
        profile.username = username ?: ""
        apiSource.getProfile(profile)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<ProfileResponse>{
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: ProfileResponse) {
                    t.data?.let {
                        state.postValue(ProfileVS.SetProfile(it))
                    }
                }

                override fun onError(e: Throwable) {
                    state.postValue(ProfileVS.Error)
                }

                override fun onComplete() {
                }

            })
    }

    fun updateProfile(profile:UpdateProfileRequest){
        val username = session.getData<String>(SessionKey.USERNAME.name)
        profile.username = username ?: ""
        apiSource.updateProfile(profile)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<ProfileResponse>{
                override fun onSubscribe(d: Disposable) { }

                override fun onNext(t: ProfileResponse) {
                    if(t.success) {
                        state.postValue(ProfileVS.PositiveResponseFromUpdateProfile)
                    }else{
                        state.postValue(ProfileVS.Error)
                    }
                }

                override fun onError(e: Throwable) {
                    state.postValue(ProfileVS.Error)
                }

                override fun onComplete() {  }

            })
    }
}