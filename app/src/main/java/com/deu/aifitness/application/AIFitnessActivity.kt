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
    fun addFragment(fragment:AIFitnessFragment<*,*>){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(getContainerId(), fragment)
        fragmentTransaction.commit()
    }

    open fun stateChange(state:AIFitnessState?){

    }


}