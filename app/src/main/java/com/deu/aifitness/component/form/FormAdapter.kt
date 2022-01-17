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
        }
    }
    private fun validateEmail(label: String): String {
        return if (!Patterns.EMAIL_ADDRESS.matcher(label).matches()) {
            "Invalid email"
        } else {
            ""

        }
    }
}

/*

ETinput.setText(itemList[position].formType.placeholder)
            TVtitle.hint = itemList[position].formType.title

            if (itemList[position].formType == FormAttribute.PASSWORD || itemList[position].formType == FormAttribute.PASSWORDCONFIRM) {
                ETinput.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            if (itemList[position].formType == FormAttribute.NAME || itemList[position].formType == FormAttribute.SURNAME) { // DOESNT WORK
                ETinput.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            }

            val listener = object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    temp = ETinput.text.toString()
                    if (itemList[position].formType == FormAttribute.PASSWORD) {
                        //comment to prevent code smell
                    } else if (itemList[position].formType == FormAttribute.EMAIL) {
                        if (!validateEmail(temp).isEmpty()) {
                            ETinput.setError("")
                        }
                        TVerror.text = validateEmail(temp)
                    } else if (itemList[position].formType == FormAttribute.NAME) {
                        //comment to prevent code smell
                    } else if (itemList[position].formType == FormAttribute.SURNAME) {
                        //comment to prevent code smell
                    }
                }
                override fun afterTextChanged(p0: Editable?) {
                    itemList[position].formItemValue = p0.toString()
                }
            }
            ETinput.addTextChangedListener(listener)
 */