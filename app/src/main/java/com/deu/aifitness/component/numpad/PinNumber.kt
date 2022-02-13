package com.deu.aifitness.component.numpad

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ComponentPinNumberBinding


class PinNumber : ConstraintLayout {

    private var counter = 0
    private lateinit var binding: ComponentPinNumberBinding

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
            }
        }
    }

    fun addNumber(number:Int){
        if (counter<5){
            list.add(number)
            updateUIIncrement()
            updateUI()
        }
    }

    fun deleteNumber(){
        if (counter>0){
            list.removeLast()
            updateUIDecrement()
            updateUI()
        }
    }

    fun getNumbers():List<Int> = list.toList()
}
