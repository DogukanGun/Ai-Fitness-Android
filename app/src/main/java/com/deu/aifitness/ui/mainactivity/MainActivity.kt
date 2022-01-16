package com.deu.aifitness.ui.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.databinding.ActivityMainBinding
import com.deu.aifitness.ui.homepage.HomeActivity
import com.deu.aifitness.ui.user.operation.UserOperationActivity
import javax.inject.Inject

class MainActivity: AIFitnessActivity<MainActivityVM,ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getLayoutVM(): MainActivityVM = mainActivityVM

    @Inject
    lateinit var mainActivityVM: MainActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //startActivity(Intent(this,HomeActivity::class.java))
        binding?.loginButton?.setOnClickListener {
            val intent = Intent(this,UserOperationActivity::class.java)
            intent.putExtra("type",AppConstants.UserOperation.Login)
            startActivity(intent)
            //activityStart(UserOperationActivity(),AppConstants.UserOperation.Login)
        }

        binding?.registerButton?.setOnClickListener {
            activityStart(UserOperationActivity(),AppConstants.UserOperation.Register)
        }

        setContentView(binding?.root)
    }

    private fun activityStart(activity:AppCompatActivity,type:AppConstants.UserOperation){
        val intent = Intent(this,activity::class.java)
        intent.putExtra("type",type.value)
        startActivity(intent)
    }


}