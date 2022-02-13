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
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ComponentNumpadBinding

open class Numpad : ConstraintLayout {

    lateinit var binding: ComponentNumpadBinding
    lateinit var listener: NumpadListener


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
            R.layout.component_numpad,
            this,
            true
        )

        binding.apply {
            zeroBTN.setOnClickListener(numButtonPressed)
            oneBTN.setOnClickListener(numButtonPressed)
            twoBTN.setOnClickListener(numButtonPressed)
            threeBTN.setOnClickListener(numButtonPressed)
            fourBTN.setOnClickListener(numButtonPressed)
            fiveBTN.setOnClickListener(numButtonPressed)
            sixBTN.setOnClickListener(numButtonPressed)
            sevenBTN.setOnClickListener(numButtonPressed)
            eightBTN.setOnClickListener(numButtonPressed)
            nineBTN.setOnClickListener(numButtonPressed)
            deleteIB.setOnClickListener { listener.deleteButtonPressed() }
            okayIB.setOnClickListener { listener.enterButtonPressed() }
        }


    }

    private val numButtonPressed = OnClickListener {
        listener.buttonPressed((it.tag as String).toInt())
    }

}