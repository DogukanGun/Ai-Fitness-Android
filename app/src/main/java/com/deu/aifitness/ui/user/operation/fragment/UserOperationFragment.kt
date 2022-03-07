package com.deu.aifitness.ui.user.operation.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.component.dialog.AIFitnessDialogListener
import com.deu.aifitness.component.dialog.DialogContent
import com.deu.aifitness.data.constant.SelectButtons
import com.deu.aifitness.data.form.AlternativeOperation
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.databinding.FragmentUserOperationBinding
import com.deu.aifitness.ui.homepage.HomeActivity
import com.deu.aifitness.ui.user.operation.fragment.viewpager.ViewPagerAdapter
import com.deu.aifitness.ui.user.operation.fragment.viewpager.ViewPagerFragment
import com.deu.aifitness.ui.user.operation.fragment.viewpager.ViewPagerListener
import javax.inject.Inject

class UserOperationFragment
    : AIFitnessFragment<UserOperationFragmentVM,FragmentUserOperationBinding>(){

    @Inject
    lateinit var userOperationFragmentVM:UserOperationFragmentVM

    override fun getLayoutId(): Int = R.layout.fragment_user_operation

    override fun getLayoutVM(): UserOperationFragmentVM = userOperationFragmentVM

    override fun hasSelectButton(): Boolean = true

    var pagerStatus = SelectButtons.SELECT_BUTTON1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val adapter = ViewPagerAdapter((activity as AIFitnessActivity<*, *>))
        binding?.form?.let {
            adapter.viewPagerListener = viewPagerListener
            it.adapter = adapter
            it.registerOnPageChangeCallback(viewPagerScrollListener)
        }
        setAppBar()
        setSelectButton1Listener(selectButton1Listener)
        setSelectButton2Listener(selectButton2Listener)
        return view
    }


    override fun stateChange(state: AIFitnessState) {
        when(state){
            UserOperationFragmentVS.UserOperationDone ->{
                startActivity(HomeActivity::class.java)
            }
            is UserOperationFragmentVS.LoginUserComingFromRegister ->{
                viewModel?.loginUser(state.loginUser)
            }
            is UserOperationFragmentVS.StartLauncher ->{
                startLauncher(state.alternativeOperation)
            }
            UserOperationFragmentVS.UserOperationError ->{
                showErrorMessage()
            }
        }
    }

    private val viewPagerScrollListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            if (state == ViewPager2.SCROLL_STATE_SETTLING){
                if (pagerStatus == SelectButtons.SELECT_BUTTON1){
                    changeStatus2()
                }else if (pagerStatus == SelectButtons.SELECT_BUTTON2){
                    changeStatus1()
                }
            }
        }
    }

    private fun showErrorMessage(){
        val dialogContent = DialogContent(title = "Test Error",
            message = "Test Error Message", buttonNegativeContext = null)
        showDialog(dialogContent,dialogListener)

    }

    private val dialogListener = object :AIFitnessDialogListener{
        override fun positiveResponse() {
        }

        override fun negativeResponse() {
        }

    }
    private fun changeStatus1(){
        changeButtonState(SelectButtons.SELECT_BUTTON1)
        binding?.form?.setCurrentItem(SelectButtons.SELECT_BUTTON1.id,true)
        pagerStatus = SelectButtons.SELECT_BUTTON1

    }

    private fun changeStatus2(){
        changeButtonState(SelectButtons.SELECT_BUTTON2)
        binding?.form?.setCurrentItem(SelectButtons.SELECT_BUTTON2.id,true)
        pagerStatus = SelectButtons.SELECT_BUTTON2
    }
    private val selectButton1Listener = View.OnClickListener {
        changeStatus1()
    }

    private val selectButton2Listener = View.OnClickListener {
        changeStatus2()
    }

    private val viewPagerListener = object :ViewPagerListener{
        override fun registerUser(registerUser: RegisterUser) {
            viewModel?.registerUser(registerUser)
        }

        override fun loginUser(loginUser: LoginUser) {
            viewModel?.loginUser(loginUser)
        }

        override fun alternativeRegisterPressed(alternativeOperation: AlternativeOperation) {
            viewModel?.alternativeRegisterPressed(alternativeOperation)
        }

        override fun alternativeLoginPressed(alternativeOperation: AlternativeOperation) {
            viewModel?.alternativeLoginPressed(alternativeOperation)
        }
    }
}