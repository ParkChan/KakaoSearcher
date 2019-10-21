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
import com.example.kakaosearcher.kakaoaddress.model.AddressModel
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.kakaoaddress.viewmodel.AddressViewModel

class MainFragment : BaseFragment<FragmentMainBinding>(
    R.layout.fragment_main
) {
    val adapter = AddressAdapter()

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

        binding.vm?.addressList?.observe(viewLifecycleOwner, Observer { addressList ->
            val list: List<AddressModel> = addressList
            adapter.replaceListData(list)
        })

        binding.vm?.throwable?.observe(viewLifecycleOwner, Observer { t ->
            Toast.makeText(
                activity,
                t.message,
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    private fun initAdapter() {

        binding.rvFragmentMainList.adapter = this.adapter

        //TestData
        val list = ArrayList<AddressModel>()
        list.add(AddressModel("서울 테스트 1"))
        list.add(AddressModel("서울 테스트 2"))
        list.add(AddressModel("서울 테스트 3"))
        list.add(AddressModel("서울 테스트 4"))
        list.add(AddressModel("서울 테스트 5"))
        list.add(AddressModel("서울 테스트 6"))
        this.adapter.replaceListData(list)
    }
}