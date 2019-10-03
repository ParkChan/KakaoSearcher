package com.example.kakaosearcher.kakaoaddress.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kakaosearcher.R
import com.example.kakaosearcher.kakaoaddress.adapter.AddressAdapter
import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSourceImpl
import com.example.kakaosearcher.kakaoaddress.model.resmodel.AddressModel
import com.example.kakaosearcher.kakaoaddress.presenter.AddressContract
import com.example.kakaosearcher.kakaoaddress.presenter.AddressPresenter
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), AddressContract.View {

    override val presenter: AddressContract.Presenter = AddressPresenter(
            this,
            AddressRepository(AddressDataSourceImpl())
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

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
            presenter.searchAddress(et_fragment_main_input_text.text.toString())
        }
    }

    override fun updateAddressList(addressList: List<AddressModel>) {
        Toast.makeText(context, "onSuccess", Toast.LENGTH_SHORT).show()
        addressAdapter.setAddressList(addressList)
    }

    override fun showErrorMesage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.dispose()
        super.onDestroy()
    }
}