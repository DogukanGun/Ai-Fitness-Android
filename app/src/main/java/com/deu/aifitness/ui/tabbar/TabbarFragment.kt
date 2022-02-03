package com.deu.aifitness.ui.tabbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.databinding.FragmentTabbarBinding
import com.deu.aifitness.ui.homepage.HomeFragment
import com.deu.aifitness.ui.profile.ProfileFragment
import com.deu.aifitness.ui.workoutpage.WorkoutFragment
import javax.inject.Inject

class TabbarFragment : AIFitnessFragment<TabbarVM,FragmentTabbarBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_tabbar

    override fun getLayoutVM(): TabbarVM = tabbarVM

    @Inject
    lateinit var tabbarVM: TabbarVM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }



    override fun stateChange(state: AIFitnessState) {
        when(state){
            TabbarVS.Homepage ->{
                binding?.apply {
                    exerciseTB.notClicked()
                    profileTB.notClicked()
                    homeButtonTB.clicked()
                }
                replaceFragment(HomeFragment())
            }
            TabbarVS.Exercise ->{
                binding?.apply {
                    homeButtonTB.notClicked()
                    exerciseTB.clicked()
                    profileTB.notClicked()
                }
                replaceFragment(WorkoutFragment())
            }
            TabbarVS.Profile ->{
                binding?.apply {
                    exerciseTB.notClicked()
                    homeButtonTB.notClicked()
                    profileTB.clicked()
                }
                replaceFragment(ProfileFragment())
            }
        }
    }



}