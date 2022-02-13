package com.deu.aifitness.dinjection

import android.app.Application
import android.content.pm.PackageManager
import com.deu.aifitness.application.AIFitnessSession
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application) = application.applicationContext

}