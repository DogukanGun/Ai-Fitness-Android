package com.deu.aifitness.component.aitextinput

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextPaint
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.deu.aifitness.R
import com.deu.aifitness.data.form.ErrorMessage
import com.deu.aifitness.data.form.FormAttribute
import com.deu.aifitness.databinding.ComponentAiTextInputBinding
import androidx.lifecycle.LifecycleOwner




class AITextInput : LinearLayout {


    lateinit var binding:ComponentAiTextInputBinding
    var listener:AITextInputListener? = null
    var inputType=MutableLiveData<FormAttribute>(FormAttribute.USERNAME)

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
            R.layout.component_ai_text_input,
            this,
            true
        )
        if (!inputType.hasActiveObservers()){
            inputType.observe((context as LifecycleOwner), Observer {
                setTitle()
            })
        }
        binding.ETinput.addTextChangedListener(textWatcher)
        binding.ETinput.setOnEditorActionListener(editorActionListener)
    }
    private fun setTitle(){
        binding.TVtitle.text = inputType.value?.title
        binding.ETinput.hint = inputType.value?.placeholder
    }
    private fun setError(){
        binding.TVerror.text = ErrorMessage.valueOf(inputType.value!!.name).message
    }

    private var textWatcher = object :TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            listener?.textChange(p0.toString())
        }
    }

    private var editorActionListener = object :TextView.OnEditorActionListener{
        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            listener?.buttonPressed(p2!!)
            return true
        }
    }
}