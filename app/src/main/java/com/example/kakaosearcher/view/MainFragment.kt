package com.example.kakaosearcher.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakaosearcher.R
import com.example.kakaosearcher.adapter.AddressAdapter
import com.example.kakaosearcher.controller.AddressController
import com.example.kakaosearcher.network.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    val addressAdapter = AddressAdapter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        initListener()
    }

    fun initAdapter(){
        val layoutManager = LinearLayoutManager(context)
        rv_fragment_main_list.layoutManager = layoutManager
        rv_fragment_main_list.adapter = addressAdapter
    }

    fun initListener(){
        btn_fragment_main_search.setOnClickListener { view ->
            AddressController().requestAddress(
                et_fragment_main_input_text.text.toString(),
                object : RetrofitListener<AddressDto> {
                    override fun onSuccess(responseData: AddressDto) {
                        Toast.makeText(context, "onSuccess", Toast.LENGTH_SHORT).show()

                        var addressModel = responseData?.addressList
                        addressModel?.run {
                            addressAdapter.setAddressList(addressModel)
                        }
                    }
                    override fun onReissuedAccessToken() {
                        Toast.makeText(context, "onReissuedAccessToken", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFail(msg: String) {
                        Toast.makeText(context, "onFail", Toast.LENGTH_SHORT).show()
                    }

                    override fun onNetworkError(msg: String) {
                        Toast.makeText(context, "onNetworkError", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

}