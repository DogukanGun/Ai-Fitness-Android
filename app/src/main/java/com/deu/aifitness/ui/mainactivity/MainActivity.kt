package com.deu.aifitness.ui.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ActivityMainBinding
import com.deu.aifitness.ui.user.login.LoginActivity
import com.deu.aifitness.ui.user.register.RegisterActivity
import javax.inject.Inject

class MainActivity: AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.loginButton.setOnClickListener {
            activityStart(LoginActivity())
        }

        binding.registerButton.setOnClickListener {
            activityStart(RegisterActivity())
        }

        setContentView(binding.root)
    }

    private fun activityStart(activity:AppCompatActivity){
        val intent = Intent(this,activity::class.java)
        startActivity(intent)
    }
}