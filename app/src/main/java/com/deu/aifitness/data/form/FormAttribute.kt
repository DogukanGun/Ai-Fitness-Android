package com.deu.aifitness.data.form

enum class FormAttribute(val placeholder:String,val title:String) {
    USERNAME("username","Username"),
    NAME("name","Name"),
    SURNAME("surname","Surname"),
    PASSWORD("password","Password"),
    BIRTHDAY("birthday","Birthday"),
    EMAIL("email","Email"),
    PHONE("phone","Phone"),
    PASSWORDCONFIRM("password again","Password")
}