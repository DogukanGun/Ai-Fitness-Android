package com.deu.aifitness.ui.user.operation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.component.form.Form
import com.deu.aifitness.databinding.ActivityUserOperationBinding
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import javax.inject.Inject

class UserOperationActivity : AppCompatActivity() {

    @Inject
    lateinit var userOperationFragment: UserOperationFragment
    lateinit var binding:ActivityUserOperationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_operation)
        createForm()
        setContentView(binding.root)
    }

    private fun createForm(){
        val intentData = intent.getIntExtra("type",-1)


        if(intentData!=-1){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val form = Form(getValue(intentData))
            fragmentTransaction.add(binding.fragmentContainerView.id,form)
            fragmentTransaction.commit()
        }else{
            // TODO: 28.11.2021 Buraya hata mesajı basmak lazım
        }

    }

    private fun getValue(value:Int):AppConstants.UserOperation{
        if(value==2)
            return AppConstants.UserOperation.Login
        return AppConstants.UserOperation.Register
    }








}