package com.deu.aifitness.ui.developerstartpage

sealed class DeveloperStartPageVS {
    object environmentChangeToHost:DeveloperStartPageVS()
    object environmentChangeToLocal:DeveloperStartPageVS()

}