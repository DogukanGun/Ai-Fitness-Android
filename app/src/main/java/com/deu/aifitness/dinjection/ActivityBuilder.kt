package com.deu.aifitness.dinjection

import com.deu.aifitness.ui.user.UserModule
import com.deu.aifitness.ui.user.operation.UserOperationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun provideUserOperationActivity():UserOperationActivity





}