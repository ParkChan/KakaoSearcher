package com.example.kakaosearcher.kakaoaddress.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kakaosearcher.BR
import com.example.kakaosearcher.R
import com.example.kakaosearcher.common.BaseFragment
import com.example.kakaosearcher.common.BaseRecyclerView
import com.example.kakaosearcher.databinding.FragmentMainBinding
import com.example.kakaosearcher.databinding.ItemAddressBinding
import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSourceImpl
import com.example.kakaosearcher.kakaoaddress.model.AddressModel
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.kakaoaddress.viewmodel.AddressViewModel

class MainFragment : BaseFragment<FragmentMainBinding>(
    R.layout.fragment_main
) {
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        initListener()
    }

    private fun initAdapter() {
        binding.rvFragmentMainList.run {
            setHasFixedSize(true)
            adapter =
                object :
                    BaseRecyclerView.BaseAdapter<List<AddressModel>, ItemAddressBinding>(
                        R.layout.item_address,
                        BR.addressModel
                    ) {}
        }

    }

    private fun initListener() {
        binding.vm?.throwable?.observe(viewLifecycleOwner, Observer { t ->
            Toast.makeText(
                activity,
                t.message,
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}