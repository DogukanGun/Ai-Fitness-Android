package com.deu.aifitness.dinjection

import com.deu.aifitness.component.form.FormVM
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageVM
import com.deu.aifitness.ui.homepage.HomeFragmentVM
import com.deu.aifitness.ui.homepage.HomeVM
import com.deu.aifitness.ui.mainactivity.MainActivityVM
import com.deu.aifitness.ui.user.operation.UserOperationVM
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragmentVM
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideDeveloperStartPageVM() = DeveloperStartPageVM()

    @Provides
    fun provideMainActivityVM() = MainActivityVM()

    @Provides
    fun provideUserOperationVM() = UserOperationVM()

    @Provides
    fun provideUserOperationFragmentVM() = UserOperationFragmentVM()

    @Provides
    fun provideFormVM() = FormVM()

    @Provides
    fun provideHomeVM() = HomeVM()

    @Provides
    fun provideHomeFragmentVM() = HomeFragmentVM()
}