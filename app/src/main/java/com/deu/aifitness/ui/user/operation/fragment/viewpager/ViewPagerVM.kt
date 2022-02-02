package com.deu.aifitness.ui.user.operation.fragment.viewpager

import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragmentVS
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ViewPagerVM :AIFitnessVM() {}