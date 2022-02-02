package com.deu.aifitness.dinjection

import com.deu.aifitness.component.form.FormVM
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageVM
import com.deu.aifitness.ui.homepage.HomeFragmentVM
import com.deu.aifitness.ui.homepage.HomeVM
import com.deu.aifitness.ui.mainactivity.MainActivityVM
import com.deu.aifitness.ui.tabbar.TabbarFragment
import com.deu.aifitness.ui.tabbar.TabbarVM
import com.deu.aifitness.ui.user.operation.UserOperationVM
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragmentVM
import com.deu.aifitness.ui.user.operation.fragment.viewpager.ViewPagerVM
import com.deu.aifitness.ui.workoutpage.ExerciseVM
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
    fun provideUserOperationFragmentVM(apiSource: ApiSource) = UserOperationFragmentVM(apiSource)

    @Provides
    fun provideFormVM() = FormVM()

    @Provides
    fun provideHomeVM() = HomeVM()

    @Provides
    fun provideHomeFragmentVM() = HomeFragmentVM()

    @Provides
    fun provideViewPagerVM() = ViewPagerVM()

    @Provides
    fun provideTabbarVM() = TabbarVM()

    @Provides
    fun provideExerciseVM() = ExerciseVM()
}