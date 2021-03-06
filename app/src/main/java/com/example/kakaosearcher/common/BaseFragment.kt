package com.example.kakaosearcher.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<BINDING : ViewDataBinding>(
    @LayoutRes
    private val layoutResId: Int
) : Fragment() {
    abstract fun initBindViewModel()
    protected lateinit var binding: BINDING
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            layoutResId,
            container,
            false
        )
        initBindViewModel()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    fun showToast(msg: String?) = Toast.makeText(
        activity,
        msg,
        Toast.LENGTH_SHORT
    ).show()
}