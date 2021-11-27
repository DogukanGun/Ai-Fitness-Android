package com.deu.aifitness.ui.user.register

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ActivityRegisterBinding
import com.deu.aifitness.ui.user.register.fragment.RegisterFragment
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    @Inject
    lateinit var registerFragment: RegisterFragment


    lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register)

        setContentView(binding.root)
     }






}