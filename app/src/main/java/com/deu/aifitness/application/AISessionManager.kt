package com.deu.aifitness.application

class AISessionManager {

    private val sessionList = HashMap<String,Any>()

    fun putData(key:String,value:Any){
        sessionList[key] = value
    }

    fun <T> getData(key:String): T? = sessionList[key] as T

    fun hasData(key:String): Boolean = sessionList.containsKey(key)

    fun remove(key:String) = sessionList.remove(key)

}