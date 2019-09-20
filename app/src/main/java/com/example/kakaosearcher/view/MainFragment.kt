package com.example.kakaosearcher.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kakaosearcher.R
import com.example.kakaosearcher.controller.AddressController
import com.example.kakaosearcher.network.model.resmodel.AddressModel
import com.example.kakaosearcher.network.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_fragment_main_search.setOnClickListener { view ->
            AddressController().requestAddress(
                et_fragment_main_input_text.text.toString(),
                object : RetrofitListener<List<AddressModel>> {
                    override fun onSuccess(responseData: List<AddressModel>) {

                    }

                    override fun onReissuedAccessToken() {
                    }

                    override fun onFail(msg: String) {
                    }

                    override fun onNetworkError(msg: String) {
                    }
                })
        }
    }
}