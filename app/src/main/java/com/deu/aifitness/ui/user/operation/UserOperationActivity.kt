package com.deu.aifitness.ui.user.operation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.component.form.Form
import com.deu.aifitness.databinding.ActivityUserOperationBinding
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import javax.inject.Inject

class UserOperationActivity : AppCompatActivity() {

    lateinit var binding:ActivityUserOperationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_operation)
        getValueOfOperation()
        setContentView(binding.root)
    }


    private fun getValueOfOperation(){
        val intentData = intent.getIntExtra("type",-1)
        if (intentData!=-1){
            UserOperationState.currentStatus=getValue(intentData)
        }else{
            // TODO: 28.11.2021 Burada popup ile hata verilebilr belki ana sayfaya geri döner
        //  yada uygulama kapatılır
        }

    }

    private fun getValue(value:Int): AppConstants.UserOperation{
        if(value==2)
            return AppConstants.UserOperation.Login
        return AppConstants.UserOperation.Register
    }












}