package com.deu.aifitness.data.form

import com.deu.aifitness.component.form.FormItem

data class FormFields(
    var username:String?,
    var name:String?,
    var surname: String?,
    var password:String?,
    var birthday:String?,
    var email:String?,
    var phone:String?
            ){
    companion object{
        fun convertFromFormItem(list:List<FormItem>):FormFields{
            var formField = FormFields(null,null,null,null
            ,null,null,null)
            for (item in list){
                when(item.formType){
                    FormAttribute.NAME->{
                        formField.name = item.formItemValue
                    }
                    FormAttribute.SURNAME->{
                        formField.surname = item.formItemValue
                    }
                    FormAttribute.PASSWORD->{
                        formField.password = item.formItemValue
                    }
                    FormAttribute.PASSWORD_CONFIRM->{
                        //prevent code smell
                    }
                    FormAttribute.USERNAME->{
                        formField.username = item.formItemValue
                    }
                    FormAttribute.BIRTHDAY->{
                        formField.birthday = item.formItemValue
                    }
                    FormAttribute.EMAIL->{
                        formField.email = item.formItemValue
                    }
                    FormAttribute.PHONE->{
                        formField.phone = item.formItemValue
                    }
                }
            }

            return  formField
        }
    }

}