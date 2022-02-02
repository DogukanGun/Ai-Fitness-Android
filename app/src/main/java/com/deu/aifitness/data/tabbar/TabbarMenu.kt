package com.deu.aifitness.data.tabbar

import android.content.Context
import android.graphics.drawable.Drawable
import com.deu.aifitness.R

enum class TabbarMenu(val id:Int) {
    HOME(1){
        override fun getString(context: Context):String{
            return context.getString(R.string.home)
        }
        override fun getDrawable(context: Context): Drawable? {
            return context.getDrawable(R.drawable.ic_baseline_home)
        }},
    EXERCISE(2){
        override fun getString(context: Context):String{
            return context.getString(R.string.exercise)
        }
        override fun getDrawable(context: Context): Drawable? {
            return context.getDrawable(R.drawable.ic_baseline_directions_run_24)
        } },
    PROFILE(3){
        override fun getString(context: Context):String{
            return context.getString(R.string.profile)
        }

        override fun getDrawable(context: Context): Drawable? {
            return context.getDrawable(R.drawable.ic_baseline_account_circle_24)
        }
    };

    abstract fun getString(context: Context):String
    abstract fun getDrawable(context: Context):Drawable?

}