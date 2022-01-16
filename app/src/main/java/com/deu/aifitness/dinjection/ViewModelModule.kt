package com.deu.aifitness.dinjection

import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageVM
import com.deu.aifitness.ui.mainactivity.MainActivity
import com.deu.aifitness.ui.mainactivity.MainActivityVM
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideDeveloperStartPageVM() = DeveloperStartPageVM()

    @Provides
    fun provideMainActivityVM() = MainActivityVM()
}