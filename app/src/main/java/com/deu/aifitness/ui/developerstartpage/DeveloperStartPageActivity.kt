package com.deu.aifitness.ui.developerstartpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ActivityDeveloperStartPageBinding

class DeveloperStartPageActivity : AppCompatActivity() {
    lateinit var binding:ActivityDeveloperStartPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_developer_start_page)
        setContentView(binding.root)
    }
}