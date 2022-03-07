package com.deu.aifitness.dinjection

import android.app.Application
import com.deu.aifitness.application.AISessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    @Singleton
    fun provideSession() = AISessionManager()

}