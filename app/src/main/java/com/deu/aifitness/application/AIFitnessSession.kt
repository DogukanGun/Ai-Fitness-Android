package com.deu.aifitness.application

class AIFitnessSession {

    private var sessionMap = hashMapOf<String,String>()

    fun getData(key:String):String?{
        return sessionMap[key]
    }

    fun contains(key: String):Boolean{
        return sessionMap[key] != null
    }

    fun putData(key: String,value:String){
        sessionMap.put(key,value)
    }

    companion object{
        fun getInstance():AIFitnessSession =
            AIFitnessSession()
    }
}