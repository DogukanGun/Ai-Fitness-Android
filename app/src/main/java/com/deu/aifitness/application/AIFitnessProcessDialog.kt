package com.deu.aifitness.application

import android.animation.Animator
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import com.airbnb.lottie.LottieAnimationView
import com.deu.aifitness.R
import com.deu.aifitness.data.animation.AnimationType

class AIFitnessProcessDialog: Dialog {

    private lateinit var animationType: AnimationType

    var listener:HocamAnimationListener? = null

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    constructor(context: Context, animationType: AnimationType = AnimationType.LOADING): super(context,android.R.style.Theme_Translucent){
        this.animationType = animationType
        init()

    }

    private fun init(){
        val root = LayoutInflater.from(context).inflate(R.layout.component_lottie_dialog,null)
        setContentView(root)
        val animationView = findViewById<LottieAnimationView>(R.id.animationLAV)
        if (animationType == AnimationType.ERROR){
            animationView.setAnimation("animation/error.json")
            animationView.addAnimatorListener(animationListener)
            animationView.loop(false)
        }else if (animationType == AnimationType.UPLOAD){
            animationView.setAnimation("animation/upload.json")
            animationView.addAnimatorListener(animationListener)
            animationView.loop(false)
        }
    }


    private val animationListener = object : Animator.AnimatorListener{
        override fun onAnimationStart(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            listener?.finishAnimation()
        }

        override fun onAnimationCancel(p0: Animator?) {
            listener?.finishAnimation()
        }

        override fun onAnimationRepeat(p0: Animator?) {
            listener?.finishAnimation()
        }

    }

    interface HocamAnimationListener{
        fun finishAnimation()
    }
}