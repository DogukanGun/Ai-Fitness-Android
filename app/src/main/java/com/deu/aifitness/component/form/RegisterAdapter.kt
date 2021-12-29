package com.deu.aifitness.component.form

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.databinding.ItemRegisterBinding
import org.w3c.dom.Text
import java.util.regex.Pattern


class RegisterAdapter(
    var itemList: List<Register>
) : RecyclerView.Adapter<RegisterAdapter.RegisterViewHolder>() {

    inner class RegisterViewHolder(val binding: ItemRegisterBinding ) : RecyclerView.ViewHolder(
        binding.root
    ) //inner class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterViewHolder {
        val binding = ItemRegisterBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return RegisterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RegisterViewHolder, position: Int) {
        var temp: String;
        holder.binding.apply {
            ETinput.setText(itemList[position].inputText)
            TVtitle.text = itemList[position].title

            if (TVtitle.text.equals("Password") or TVtitle.text.equals("Password Again")) {
                ETinput.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            if (TVtitle.text.equals("Name") or TVtitle.text.equals("Surname")) { // DOESNT WORK
                //inputText.inputType =   InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
                ETinput.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            }

            val listener = object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    temp = ETinput.text.toString()
                    if (TVtitle.text.equals("Password")) {
                    } else if (TVtitle.text.equals("Email")) {
                        if (!validateEmail(temp).isEmpty()) {
                            ETinput.setError("")
                        }
                        TVerror.text = validateEmail(temp)
                    } else if (TVtitle.text.equals("Name")) {
                    } else if (TVtitle.text.equals("Surname")) {
                    }
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            }
            ETinput.addTextChangedListener(listener)
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