package com.deu.aifitness.dinjection

import android.app.Application
import com.deu.aifitness.application.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(ActivityBuilder::class),
    (AndroidSupportInjectionModule::class),
    (NetworkModule::class)])
interface AppComponent {

    fun inject(app: BaseApplication)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }
}