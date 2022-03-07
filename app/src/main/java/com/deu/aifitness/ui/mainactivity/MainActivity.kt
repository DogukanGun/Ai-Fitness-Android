package com.deu.aifitness.ui.mainactivity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.deu.aifitness.BuildConfig
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.databinding.ActivityMainBinding
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageActivity
import com.deu.aifitness.ui.user.operation.UserOperationActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivity: AIFitnessActivity<MainActivityVM,ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getLayoutVM(): MainActivityVM = mainActivityVM

    @Inject
    lateinit var mainActivityVM: MainActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.startTimer()
    }

    private fun startApplication(){
        lifecycleScope.launch(Dispatchers.IO) {
            delay(5000L)
            if (BuildConfig.DEVELOPMENT ){
                startActivity(UserOperationActivity::class.java)
            }else{
                startActivity(UserOperationActivity::class.java)
            }
        }
    }

    override fun stateChange(state: AIFitnessState?) {
        when(state){
            MainActivityVS.StartActivity ->{
                startApplication()
            }
        }
    }



}