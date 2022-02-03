package com.deu.aifitness.dinjection

import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageActivity
import com.deu.aifitness.ui.homepage.HomeActivity
import com.deu.aifitness.ui.homepage.HomeFragment
import com.deu.aifitness.ui.mainactivity.MainActivity
import com.deu.aifitness.ui.profile.ProfileFragment
import com.deu.aifitness.ui.settings.SettingsActivity
import com.deu.aifitness.ui.settings.SettingsFragment
import com.deu.aifitness.ui.settings.SettingsFragmentVM
import com.deu.aifitness.ui.tabbar.TabbarFragment
import com.deu.aifitness.ui.user.operation.UserOperationActivity
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import com.deu.aifitness.ui.user.operation.fragment.viewpager.ViewPagerFragment
import com.deu.aifitness.ui.workoutdetail.WorkoutActivity
import com.deu.aifitness.ui.workoutpage.WorkoutFragment
import com.deu.aifitness.ui.workoutdetail.WorkoutDetailFragment
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

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideViewPagerFragment(): ViewPagerFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideTabbarFragment(): TabbarFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideWorkoutFragment(): WorkoutFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideWorkoutDetailFragment(): WorkoutDetailFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideWorkoutActivity(): WorkoutActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideSettingsActivity(): SettingsActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun provideProfileFragment(): ProfileFragment
}
