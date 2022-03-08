package com.deu.aifitness.component.aiedittext

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
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ComponentAiEditTextBinding

/**
 * TODO: document your custom view class.
 */
class AiEditText : ConstraintLayout {

    lateinit var binding:ComponentAiEditTextBinding

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
            R.layout.component_ai_edit_text,
            this,
            true
        )
        binding.apply {
            elevation = 10F
            context.theme.obtainStyledAttributes(attrs,R.styleable.AiEditText,defStyle,defStyle)
                .apply {
                    keyTV.text = getString(R.styleable.AiEditText_keyName)
                    valueET.hint = getString(R.styleable.AiEditText_valueName)
                }
        }
    }

    fun getText():String = binding.valueET.text.toString()

}

