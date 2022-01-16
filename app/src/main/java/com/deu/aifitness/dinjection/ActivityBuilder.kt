package com.deu.aifitness.dinjection

import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageActivity
import com.deu.aifitness.ui.mainactivity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideDeveloperStartPageActivity():DeveloperStartPageActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideMainActivity():MainActivity
}