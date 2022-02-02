package com.deu.aifitness.ui.tabbar

import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.tabbar.TabbarMenu

class TabbarVM:AIFitnessVM() {

    private var currentTabState = TabbarMenu.HOME

    fun homeClicked(){
        if (currentTabState !=TabbarMenu.HOME){
            currentTabState = TabbarMenu.HOME
            state.postValue(TabbarVS.Homepage)
        }
    }

    fun exerciseClicked(){
        if (currentTabState !=TabbarMenu.EXERCISE){
            currentTabState = TabbarMenu.EXERCISE
            state.postValue(TabbarVS.Exercise)
        }
    }

    fun profileClicked(){
        if (currentTabState !=TabbarMenu.PROFILE){
            currentTabState = TabbarMenu.PROFILE
            state.postValue(TabbarVS.Profile)
        }
    }
}