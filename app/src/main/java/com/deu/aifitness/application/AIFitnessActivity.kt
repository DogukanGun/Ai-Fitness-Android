package com.deu.aifitness.application

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.deu.aifitness.BR
import com.deu.aifitness.R
import com.deu.aifitness.data.constant.Constant
import dagger.android.AndroidInjection

abstract class AIFitnessActivity<VM:AIFitnessVM,DB:ViewDataBinding>:AppCompatActivity() {

    abstract fun getLayoutId():Int

    abstract fun getLayoutVM():VM

    fun getContainerId() = R.id.container


    protected var viewModel:VM? = null
    protected var binding:DB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = getLayoutVM()
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        binding!!.setVariable(BR.viewModel,viewModel)
        (viewModel as AIFitnessVM).let{ vm->
                if(!vm.state.hasActiveObservers()){
                    vm.state.observe(this, Observer {
                        stateChange(vm.state.value)
                    })
                }
        }
    }

    fun startActivity(classAI:Class<*>){
        val intent = Intent(this,classAI)
        startActivity(intent)
    }

    fun getCurrentFragment():AIFitnessFragment<*,*>?{
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        if (currentFragment != null){
            return  currentFragment as AIFitnessFragment<*, *>
        }
        return null
    }

    override fun onBackPressed() {
        val result = back()
        if (result == -1){
            super.onBackPressed()
        }
    }

    private fun back():Int{
        val currentFragment = getCurrentFragment()
         if (currentFragment != null){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(currentFragment)
            fragmentTransaction.commitAllowingStateLoss()
            supportFragmentManager.popBackStackImmediate()
            if (supportFragmentManager.backStackEntryCount == 0) {
                return -1
            }
             return 0
        }else{
             return -1
        }

    }

    fun startActivityWithString(classAI: Class<*>,variable:String){
        val intent = Intent(this,classAI)
        intent.putExtra(Constant.paramName,variable)
        startActivity(intent)
    }
    fun addFragment(fragment:AIFitnessFragment<*,*>){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(getContainerId(),fragment,null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    open fun stateChange(state:AIFitnessState?){

    }


}