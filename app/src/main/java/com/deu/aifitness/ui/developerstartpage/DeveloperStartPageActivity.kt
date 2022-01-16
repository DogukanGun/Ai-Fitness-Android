package com.deu.aifitness.ui.developerstartpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.constant.ConnectionType
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.databinding.ActivityDeveloperStartPageBinding
import com.deu.aifitness.ui.mainactivity.MainActivity
import javax.inject.Inject

class DeveloperStartPageActivity : AIFitnessActivity<DeveloperStartPageVM,ActivityDeveloperStartPageBinding>() {

    @Inject
    lateinit var developerStartPageVM: DeveloperStartPageVM

    override fun getLayoutId(): Int = R.layout.activity_developer_start_page

    override fun getLayoutVM(): DeveloperStartPageVM = developerStartPageVM

    override fun stateChange(state: AIFitnessState?) {
        when(state){
            is DeveloperStartPageVS.EnvironmentChangeToHost->{
                Constant.connectionType = ConnectionType.HOST
                startActivity(MainActivity::class.java)
            }
            is DeveloperStartPageVS.EnvironmentChangeToLocal->{
                Constant.connectionType = ConnectionType.LOCAL
                startActivity(MainActivity::class.java)
            }
        }
    }


}