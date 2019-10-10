package com.example.kakaosearcher.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding> : Fragment() {

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun initBindViewModel()
    lateinit var binding: Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            layoutRes(),
            container,
            false
        )
        initBindViewModel()
        binding.lifecycleOwner = this

        return binding.root
    }

}