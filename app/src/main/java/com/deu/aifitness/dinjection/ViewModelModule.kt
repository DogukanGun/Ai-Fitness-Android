package com.deu.aifitness.dinjection

import android.content.Context
import android.content.pm.PackageManager
import com.deu.aifitness.application.AISessionManager
import com.deu.aifitness.component.form.FormVM
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.ui.cameraxactivity.WorkoutCameraFragmentVM
import com.deu.aifitness.ui.cameraxactivity.WorkoutCameraVM
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageVM
import com.deu.aifitness.ui.homepage.HomeFragmentVM
import com.deu.aifitness.ui.homepage.HomeVM
import com.deu.aifitness.ui.mainactivity.MainActivityVM
import com.deu.aifitness.ui.profile.ProfileFragment
import com.deu.aifitness.ui.profile.ProfileVM
import com.deu.aifitness.ui.settings.SettingsFragmentVM
import com.deu.aifitness.ui.settings.SettingsVM
import com.deu.aifitness.ui.smsotp.SmsOtpFragmentVM
import com.deu.aifitness.ui.smsotp.SmsOtpVM
import com.deu.aifitness.ui.tabbar.TabbarVM
import com.deu.aifitness.ui.user.operation.UserOperationVM
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragmentVM
import com.deu.aifitness.ui.user.operation.fragment.viewpager.ViewPagerVM
import com.deu.aifitness.ui.workoutdetail.WorkoutActivityVM
import com.deu.aifitness.ui.workoutpage.WorkoutVM
import com.deu.aifitness.ui.workoutdetail.WorkoutDetailVM
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideDeveloperStartPageVM() = DeveloperStartPageVM()

    @Provides
    fun provideMainActivityVM(apiSource: ApiSource) = MainActivityVM(apiSource)

    @Provides
    fun provideUserOperationVM() = UserOperationVM()

    @Provides
    fun provideUserOperationFragmentVM(apiSource: ApiSource,
                                       session: AISessionManager) =
        UserOperationFragmentVM(apiSource,session)

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
    fun provideWorkoutVM() = WorkoutVM()

    @Provides
    fun provideWorkoutDetailVM() = WorkoutDetailVM()

    @Provides
    fun provideWorkoutActivityVM() = WorkoutActivityVM()

    @Provides
    fun provideSettingsVM() = SettingsVM()

    @Provides
    fun provideSettingsFragmentVM() = SettingsFragmentVM()

    @Provides
    fun provideProfileVM() = ProfileVM()

    @Provides
    fun provideWorkoutCameraVM() = WorkoutCameraVM()

    @Provides
    fun provideWorkoutCameraFragmentVM() = WorkoutCameraFragmentVM()

    @Provides
    fun provideSmsOtpVM() = SmsOtpVM()

    @Provides
    fun provideSmsOtpFragmentVM() = SmsOtpFragmentVM()
}