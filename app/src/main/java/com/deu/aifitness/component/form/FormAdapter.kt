package com.deu.aifitness.component.form

import android.annotation.SuppressLint
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.view.KeyEvent
import com.deu.aifitness.component.aitextinput.AITextInputListener
import com.deu.aifitness.data.form.FormAttribute
import com.deu.aifitness.databinding.ItemRegisterBinding


class FormAdapter(
    var itemList: List<FormItem>
) : RecyclerView.Adapter<FormAdapter.FormViewHolder>() {

    inner class FormViewHolder(val binding: ItemRegisterBinding ) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder {
        val binding = ItemRegisterBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return FormViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FormViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            this.AIregisterInput.inputType.value = item.formType
            this.AIregisterInput.listener = aiTextInputListener
        }
    }
    private fun validateEmail(label: String): String {
        return if (!Patterns.EMAIL_ADDRESS.matcher(label).matches()) {
            "Invalid email"
        } else {
            ""
        }
    }


    val aiTextInputListener = object :AITextInputListener{
        override fun textChange(newText: String, inputType: FormAttribute) {
            itemList.filter {
                it.formType.title == inputType.title
            }[0].formItemValue = newText
        }
        override fun buttonPressed(keyEvent: KeyEvent) {

        }

    }
}
