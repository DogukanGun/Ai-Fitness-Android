package com.deu.aifitness.component.dialog

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.deu.aifitness.R
import com.deu.aifitness.data.session.IntentKey
import com.deu.aifitness.databinding.ComponentAifitnessdialogBinding

class AIFitnessDialog: DialogFragment(), View.OnClickListener {

    lateinit var binding:ComponentAifitnessdialogBinding
    private val layoutId = R.layout.component_aifitnessdialog
    var listener:AIFitnessDialogListener? = null
    var dialogContent:DialogContent? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        binding.apply {
            if(dialogContent?.buttonNegativeContext != null){
                this.negativeBTN.text = dialogContent?.buttonNegativeContext?.buttonText
                this.negativeBTN.visibility = if (dialogContent?.buttonNegativeContext?.buttonEnable == true)
                                                        View.VISIBLE else View.GONE
            }
            if(dialogContent?.buttonPositiveContext != null){
                this.positiveBTN.text = dialogContent?.buttonPositiveContext?.buttonText
                this.positiveBTN.visibility = if (dialogContent?.buttonPositiveContext?.buttonEnable == true)
                                                        View.VISIBLE else View.GONE
            }
            titleTV.text = dialogContent?.title
            messageTV.text = dialogContent?.message
            positiveBTN.setOnClickListener(this@AIFitnessDialog)
            negativeBTN.setOnClickListener(this@AIFitnessDialog)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogContent = arguments?.getParcelable(IntentKey.AI_DIALOG.name)

    }

    companion object{
        fun getInstance(dialogContent: DialogContent):AIFitnessDialog = AIFitnessDialog().apply {
                arguments = Bundle().apply {
                    putParcelable(IntentKey.AI_DIALOG.name,dialogContent)
                }
            }
    }

    fun show(fragmentManager:FragmentManager){
        val ft = fragmentManager.beginTransaction()
        ft.add(this,"")
        ft.commitAllowingStateLoss()
    }

    override fun onClick(v: View?) {
        if (v == binding.positiveBTN || v == binding.negativeBTN){
            when(v){
                binding.positiveBTN ->{
                    listener?.positiveResponse()
                }
                binding.negativeBTN ->{
                    listener?.negativeResponse()
                }
            }
            this.dismiss()
        }
    }
}