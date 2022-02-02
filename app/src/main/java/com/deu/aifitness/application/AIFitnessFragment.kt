package com.deu.aifitness.application

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.deu.aifitness.BR
import com.deu.aifitness.R
import com.deu.aifitness.data.constant.SelectButtons
import dagger.android.support.AndroidSupportInjection

abstract class AIFitnessFragment<VM:AIFitnessVM,DB:ViewDataBinding>:Fragment() {

    abstract fun getLayoutId():Int

    abstract fun getLayoutVM():VM

    protected var viewModel:VM? = null
    protected var binding:DB? = null

    open fun hasSelectButton() = false

    open fun hasBackButton() = false

    open fun hasSettingButton() = false

    open fun selectButton2Text() = R.string.login_button

    open fun selectButton1Text() = R.string.register_button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        binding!!.setVariable(BR.viewModel,viewModel)
        viewModel.let{ vm->
            if (vm != null) {
                if(!vm.state.hasActiveObservers()){
                    vm.state.observe(this, Observer {
                        stateChange(it)
                    })
                }

            }
        }
        return binding!!.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getLayoutVM()
    }


    private fun getAIFitnessActivity():AIFitnessActivity<*,*>?{
        getActivity().let { activity->
            return activity as AIFitnessActivity<*,*>
        }
    }

    fun setAppBar(){
        val text1 = getString(selectButton1Text())
        val text2 = getString(selectButton2Text())
        getAIFitnessActivity()?.setAppBarFromFragment(hasSelectButton(),text1,text2,hasBackButton(),hasSettingButton())
    }

    fun startActivity(classAI:Class<*>){
        getAIFitnessActivity()?.startActivity(classAI)
    }

    fun addFragment(fragment:AIFitnessFragment<*,*>){
        getAIFitnessActivity()?.addFragment(fragment)
    }

    fun replaceFragment(fragment:AIFitnessFragment<*,*>){
        getAIFitnessActivity()?.replaceFragment(fragment)
    }

    fun setSelectButton1Listener(listener:View.OnClickListener){
        getAIFitnessActivity()?.setSelectButton1Listener(listener)
    }

    fun setSelectButton2Listener(listener:View.OnClickListener){
        getAIFitnessActivity()?.setSelectButton2Listener(listener)
    }

    fun changeButtonState(selectedButton:SelectButtons){
        getAIFitnessActivity()?.changeButtonState(selectedButton)
    }

    open fun stateChange(state:AIFitnessState){

    }
}