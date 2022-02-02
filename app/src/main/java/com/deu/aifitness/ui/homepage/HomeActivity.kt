package com.deu.aifitness.ui.homepage

import android.os.Bundle
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import javax.inject.Inject
import com.deu.aifitness.databinding.ActivityHomeBinding
import com.deu.aifitness.ui.tabbar.TabbarFragment

class HomeActivity : AIFitnessActivity<HomeVM, ActivityHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun getLayoutVM(): HomeVM = homeVM

    @Inject
    lateinit var homeVM: HomeVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppBar()
        addTabbarFragment(TabbarFragment())
        addFragment(HomeFragment())
    }
}