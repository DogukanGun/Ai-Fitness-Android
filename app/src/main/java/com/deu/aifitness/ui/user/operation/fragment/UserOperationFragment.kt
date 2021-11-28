package com.deu.aifitness.ui.user.operation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.databinding.FragmentUserOperationBinding

class UserOperationFragment : Fragment() {

    lateinit var binding:FragmentUserOperationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_operation,container,false)

        return binding.root
    }

}