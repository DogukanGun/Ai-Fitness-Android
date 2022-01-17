package com.deu.aifitness.dinjection

import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageActivity
import com.deu.aifitness.ui.homepage.HomeActivity
import com.deu.aifitness.ui.homepage.HomeFragment
import com.deu.aifitness.ui.mainactivity.MainActivity
import com.deu.aifitness.ui.user.operation.UserOperationActivity
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideDeveloperStartPageActivity(): DeveloperStartPageActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun  provideUserOperationActivity(): UserOperationActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideUserOperationFragment(): UserOperationFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideHomeFragment(): HomeFragment
}