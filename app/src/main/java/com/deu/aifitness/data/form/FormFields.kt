package com.deu.aifitness.data.form

data class FormFields (
            var username:String?,
            var name:String?,
            var surname:String,
            var password:String?,
    // TODO: 28.11.2021 Buraya birthday date objesi olarak alınabilir
            var birthday:String?,
            var email:String?
        )