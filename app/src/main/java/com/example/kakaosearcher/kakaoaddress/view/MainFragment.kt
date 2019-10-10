package com.example.kakaosearcher.kakaoaddress.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kakaosearcher.R
import com.example.kakaosearcher.common.BaseFragment
import com.example.kakaosearcher.databinding.FragmentMainBinding
import com.example.kakaosearcher.kakaoaddress.adapter.AddressAdapter
import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSourceImpl
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.kakaoaddress.viewmodel.AddressViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun layoutRes(): Int {
        return R.layout.fragment_main
    }

    @Suppress("UNCHECKED_CAST")
    override fun initBindViewModel() {
        binding.vm = ViewModelProviders.of(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    AddressViewModel(
                        AddressRepository(AddressDataSourceImpl())
                    ) as T
            }
        )[AddressViewModel::class.java]
    }

    private val addressAdapter = AddressAdapter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        initListener()
    }

    private fun initAdapter() {
        rv_fragment_main_list.adapter = addressAdapter
    }

    private fun initListener() {
        btn_fragment_main_search.setOnClickListener {
            binding.run { vm?.searchAddress(et_fragment_main_input_text.text.toString()) }
        }

        binding.vm?.addressList?.observe(viewLifecycleOwner, Observer { addressList ->
            addressAdapter.setAddressList(addressList)
        })

        binding.vm?.throwable?.observe(viewLifecycleOwner, Observer { t ->
            Toast.makeText(
                activity,
                t.message,
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}