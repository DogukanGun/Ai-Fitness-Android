package com.deu.aifitness.ui.user.operation.fragment.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.constant.Constant

class ViewPagerAdapter(activity: AIFitnessActivity<*,*>): FragmentStateAdapter(activity) {

    var viewPagerListener:ViewPagerListener? = null

    override fun getItemCount(): Int = AppConstants.UserOperation.values().size

    override fun createFragment(position: Int): Fragment {
        val element = AppConstants.UserOperation.values()[position]
        Constant.userOperation = element
        val fragment = ViewPagerFragment()
        fragment.listener = viewPagerListener
        fragment.userOperationStatus = element
        return fragment
    }
}