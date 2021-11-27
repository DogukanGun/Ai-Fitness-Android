package com.deu.aifitness.ui.user

import android.content.Context
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.user.login.LoginVM
import com.deu.aifitness.ui.user.register.RegisterActivity
import com.deu.aifitness.ui.user.register.RegisterVM
import com.deu.aifitness.ui.user.register.fragment.RegisterFragment
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserModule {
    @Provides
    fun provideRegisterVM(context: Context,apiSource: ApiSource):RegisterVM = RegisterVM(
                                                                    context,apiSource)

    @Provides
    fun provideLoginVM(context: Context,retrofit: Retrofit):LoginVM = LoginVM()

    @Provides
    fun provideRegisterFragment() = RegisterFragment()

}