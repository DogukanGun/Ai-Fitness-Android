package com.deu.aifitness.application

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class AIFitnessFragment<VM:AIFitnessVM,DB:ViewDataBinding>:Fragment() {

    abstract fun getLayoutId():Int

    abstract fun getLayoutVM():VM

    protected var viewModel:VM? = null
    protected var binding:DB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        return binding!!.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getLayoutVM()
        viewModel.let{ vm->
            if (vm != null) {
                if(!vm.state.hasActiveObservers()){
                    vm.state.observe(this, Observer {
                        stateChange(it)
                    })
                }

            }
        }
    }

    fun getAIFitnessActivity():AIFitnessActivity<*,*>?{
        getActivity().let { activity->
            return activity as AIFitnessActivity<*,*>
        }
    }

    fun addFragment(fragment:AIFitnessFragment<*,*>){
        getAIFitnessActivity()?.addFragment(fragment)
    }


    open fun stateChange(state:AIFitnessState){

    }
}