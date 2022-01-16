package com.deu.aifitness.ui.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class HomeActivity : AIFitnessActivity<HomeVM,ActivityHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun getLayoutVM(): HomeVM = homeVM

    @Inject
    lateinit var homeVM: HomeVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bottomNavigationView = binding!!.bottomNavigationView
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)

//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }


}