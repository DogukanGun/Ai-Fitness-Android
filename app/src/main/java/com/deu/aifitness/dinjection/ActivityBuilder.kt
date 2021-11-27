package com.deu.aifitness.dinjection

import androidx.appcompat.app.AppCompatActivity
import com.deu.aifitness.ui.mainactivity.MainActivity
import com.deu.aifitness.ui.mainactivity.MainActivityModule
import com.deu.aifitness.ui.user.UserModule
import com.deu.aifitness.ui.user.register.RegisterActivity
import com.deu.aifitness.ui.user.register.fragment.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun provideRegisterActivity():RegisterActivity





}