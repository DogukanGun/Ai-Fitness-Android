package com.deu.aifitness.component.numpad

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextPaint
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ComponentPinNumberBinding
import java.lang.StringBuilder


class PinNumber : ConstraintLayout {

    private var counter = 0
    private lateinit var binding: ComponentPinNumberBinding
    var pinNumberType = PinNumberType.TELEPHONE

    private var list = mutableListOf<Int>()

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.component_pin_number,
            this,
            true
        )
        changeUI()
        binding.phoneNumberTV.addTextChangedListener(phoneTextWatcher)
    }

    private val phoneTextWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            editText(s)
        }

    }

    private fun editText(s: Editable?){
        binding.phoneNumberTV.removeTextChangedListener(phoneTextWatcher)
        val text = s?.toString()
        s?.clear()
        s?.append(text?.let { phoneNumberEdit(it) })
        binding.phoneNumberTV.addTextChangedListener(phoneTextWatcher)
    }

    fun changeUI(){
        binding.apply {
            pinBox1TV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) GONE else VISIBLE
            pinBox2TV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) GONE else VISIBLE
            pinBox3TV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) GONE else VISIBLE
            pinBox4TV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) GONE else VISIBLE
            pinBox5TV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) GONE else VISIBLE
            pinBox6TV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) GONE else VISIBLE
            phoneNumberTV.visibility = if (pinNumberType == PinNumberType.TELEPHONE) VISIBLE else GONE
            textView2.visibility = if (pinNumberType == PinNumberType.TELEPHONE) VISIBLE else GONE
            titleTV.setText(if (pinNumberType == PinNumberType.TELEPHONE) R.string.phone_number else R.string.sms_number)
            counter = 0
            list.clear()
        }
    }

    private fun updateUIIncrement(){
        binding.apply {

            deselectItem()
            when(counter){
                0->{
                    this.pinBox1TV.text = list.last().toString()
                }
                1->{
                    this.pinBox2TV.text = list.last().toString()
                }
                2->{
                    this.pinBox3TV.text = list.last().toString()
                }
                3->{
                    this.pinBox4TV.text = list.last().toString()
                }
                4->{
                    this.pinBox5TV.text = list.last().toString()
                }
                5->{
                    this.pinBox6TV.text = list.last().toString()
                }
            }
            counter+=1
            selectItem()
        }
    }

    private fun selectItem(){
        binding.apply {
            when(counter){
                0->{
                    this.pinBox1TV.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                }
                1->{
                    this.pinBox2TV.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                }
                2->{
                    this.pinBox3TV.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                }
                3->{
                    this.pinBox4TV.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                }
                4->{
                    this.pinBox5TV.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                }
                5->{
                    this.pinBox6TV.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                }
            }
        }
    }

    private fun deselectItem(){
        binding.apply {
            when(counter){
                0->{
                    this.pinBox1TV.background = ContextCompat.getDrawable(context,R.drawable.bg_pin_number_not_selected)
                }
                1->{
                    this.pinBox2TV.background = ContextCompat.getDrawable(context,R.drawable.bg_pin_number_not_selected)
                }
                2->{
                    this.pinBox3TV.background = ContextCompat.getDrawable(context,R.drawable.bg_pin_number_not_selected)
                }
                3->{
                    this.pinBox4TV.background = ContextCompat.getDrawable(context,R.drawable.bg_pin_number_not_selected)
                }
                4->{
                    this.pinBox5TV.background = ContextCompat.getDrawable(context,R.drawable.bg_pin_number_not_selected)
                }
                5->{
                    this.pinBox6TV.background = ContextCompat.getDrawable(context,R.drawable.bg_pin_number_not_selected)
                }
            }
        }

    }

    private fun updateUIDecrement(){
        binding.apply {
            when(counter){
                1->{
                    this.pinBox1TV.text = ""
                }
                2->{
                    this.pinBox2TV.text = ""
                }
                3->{
                    this.pinBox3TV.text = ""
                }
                4->{
                    this.pinBox4TV.text = ""
                }
                5->{
                    this.pinBox5TV.text = ""
                }
                6->{
                    this.pinBox6TV.text = ""
                }
            }
            deselectItem()
            counter-=1
        }
    }

    private fun updateUI(){
        binding.apply {
            when(counter){
                0->{
                    this.pinBox1TV.background = ContextCompat.getDrawable(context,R.drawable.bg_selected_button)
                }
                1->{
                    this.pinBox2TV.background = ContextCompat.getDrawable(context,R.drawable.bg_selected_button)
                }
                2->{
                    this.pinBox3TV.background = ContextCompat.getDrawable(context,R.drawable.bg_selected_button)
                }
                3->{
                    this.pinBox4TV.background = ContextCompat.getDrawable(context,R.drawable.bg_selected_button)
                }
                4->{
                    this.pinBox5TV.background = ContextCompat.getDrawable(context,R.drawable.bg_selected_button)
                }
                5->{
                    this.pinBox6TV.background = ContextCompat.getDrawable(context,R.drawable.bg_selected_button)
                }
            }
        }
    }

    private fun addPhoneNumber(){
        binding.phoneNumberTV.text.append(list.last().toString().toCharArray()[0])
        counter+=1
    }

    private fun deletePhoneNumber(){
        binding.phoneNumberTV.text.delete(binding.phoneNumberTV.text.length-1,binding.phoneNumberTV.text.length)
        counter-=1
    }

    fun addNumber(number:Int){
        if (pinNumberType == PinNumberType.PIN){
            if (counter<6){
                list.add(number)
                updateUIIncrement()
                updateUI()
            }
        }else{
            if (counter<10){
                list.add(number)
                addPhoneNumber()
            }
        }
    }

    fun deleteNumber(){
        if (pinNumberType == PinNumberType.PIN){
            if (counter>0){
                list.removeLast()
                updateUIDecrement()
                updateUI()
            }
        }else{
            if (counter>0){
                list.removeLast()
                deletePhoneNumber()
            }
        }
    }

    fun getNumbers():List<Int> = list.toList()
}

fun phoneNumberEdit(string: String):String{
    val str = StringBuilder(string)
        .replace("[+][9][0]".toRegex(), "")
        .replace("[^0-9]".toRegex(),"")
    val formattedString = StringBuilder()
    for (i in str.indices){
        formattedString.append(str[i])
        if (i==2 || i==5 || i==7){
            formattedString.append(" ")
        }
    }
    return formattedString.toString().trim()
}