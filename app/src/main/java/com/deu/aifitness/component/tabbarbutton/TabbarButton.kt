package com.deu.aifitness.component.tabbarbutton

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.deu.aifitness.R
import com.deu.aifitness.data.button.ButtonState
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.data.tabbar.TabbarMenu
import com.deu.aifitness.databinding.ComponentTabbarButtonBinding

/**
 * TODO: document your custom view class.
 */
class TabbarButton : LinearLayout {

    private var buttonState = MutableLiveData(ButtonState.BUTTON_NOT_SELECTED)
    lateinit var buttonTabbarMenu: TabbarMenu
    lateinit var binding:ComponentTabbarButtonBinding

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
            R.layout.component_tabbar_button,
            this,
            true
        )
        context.theme.obtainStyledAttributes(attrs, R.styleable.TabbarButton, 0, 0)
            .apply {
                val buttonTypeId = getInt(R.styleable.TabbarButton_menuType,1)
                val buttonType = TabbarMenu.values().filter { it.id == buttonTypeId }[0]
                buttonTabbarMenu = buttonType
                binding.buttonText.text = buttonType.getString(context)
                binding.button.setImageDrawable(buttonType.getDrawable(context))
            }
        if (Constant.mainActivityTabbarStatus.ordinal == buttonTabbarMenu.ordinal){
            clicked()
        }

        if (!buttonState.hasActiveObservers()){
            buttonState.observe(context as LifecycleOwner,  {
                changeState()
            })
        }

    }

    fun clicked(){
        buttonState.postValue(ButtonState.BUTTON_SELECTED)
    }

    fun notClicked(){
        buttonState.postValue(ButtonState.BUTTON_NOT_SELECTED)
    }

    private fun changeState(){
        if (buttonState.value == ButtonState.BUTTON_SELECTED){
            binding.apply {
                wrapper.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_selected)
                buttonText.visibility = View.VISIBLE
                binding.buttonText.text = buttonTabbarMenu.getString(context)
                button.backgroundTintList = ContextCompat.getColorStateList(context,R.color.primary_color)
            }
        }else{
            binding.apply {
                wrapper.background = ContextCompat.getDrawable(context,R.drawable.bg_tabbar_not_selected)
                buttonText.visibility = View.GONE
                binding.buttonText.text = ""
                button.backgroundTintList = ContextCompat.getColorStateList(context,R.color.bottom_bar)
            }
        }
    }

}