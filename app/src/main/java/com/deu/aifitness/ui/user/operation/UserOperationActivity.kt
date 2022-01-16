package com.deu.aifitness.ui.user.operation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.component.form.Form
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.databinding.ActivityUserOperationBinding
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import javax.inject.Inject

class UserOperationActivity : AIFitnessActivity<UserOperationVM,ActivityUserOperationBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_user_operation

    override fun getLayoutVM(): UserOperationVM = UserOperationVM()

    @Inject
    lateinit var userOperationVM: UserOperationVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(UserOperationFragment())
        getValueOfOperation()
     }


    private fun getValueOfOperation(){
        val intentData = intent.getStringExtra(Constant.paramName)
        val intentDataInt = intentData?.toInt()
        intentDataInt.let {
            if (intentDataInt!=null){
                if (intentDataInt!=-1){
                    UserOperationState.currentStatus=getValue(intentDataInt)
                }else{
                    // TODO: 28.11.2021 Burada popup ile hata verilebilr belki ana sayfaya geri döner
                    //  yada uygulama kapatılır
                }
            }
        }


    }

    private fun getValue(value:Int): AppConstants.UserOperation{
        if(value==2)
            return AppConstants.UserOperation.Login
        return AppConstants.UserOperation.Register
    }

}