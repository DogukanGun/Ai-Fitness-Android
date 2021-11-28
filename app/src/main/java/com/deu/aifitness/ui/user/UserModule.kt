package com.deu.aifitness.ui.user

import android.content.Context
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.user.operation.UserOperationVM
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun provideUserOperationVM(context: Context,apiSource: ApiSource):UserOperationVM = UserOperationVM(
                                                                    context,apiSource)


    @Provides
    fun provideUserOperationFragment() = UserOperationFragment()


}