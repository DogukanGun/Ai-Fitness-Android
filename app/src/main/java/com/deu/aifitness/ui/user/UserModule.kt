package com.deu.aifitness.ui.user

import android.content.Context
import com.deu.aifitness.network.ApiServiceImpl
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.user.operation.UserOperationVM
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserModule {
    @Provides
    fun provideViewModel():UserOperationVM = UserOperationVM()

    @Provides
    fun provideUserOperationFragment() = UserOperationFragment()

    @Provides
    fun provideApiSource(retrofit: Retrofit) = ApiServiceImpl(retrofit)

}